/*
 * Copyright (C) 2008, Marek Zawirski <marek.zawirski@gmail.com> and others
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0 which is available at
 * https://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package org.eclipse.jgit.internal.storage.file;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.PackIndex.MutableEntry;
import org.eclipse.jgit.junit.RepositoryTestCase;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.junit.Test;

public abstract class PackIndexTestCase extends RepositoryTestCase {

	PackIndex smallIdx;

	PackIndex denseIdx;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		smallIdx = PackIndex.open(getFileForPack34be9032());
		denseIdx = PackIndex.open(getFileForPackdf2982f28());
	}

	/**
	 * Return file with appropriate index version for prepared pack.
	 *
	 * @return file with index
	 */
	public abstract File getFileForPack34be9032();

	/**
	 * Return file with appropriate index version for prepared pack.
	 *
	 * @return file with index
	 */
	public abstract File getFileForPackdf2982f28();

	/**
	 * Return file with appropriate index version for bad fanout table test.
	 *
	 * @return file with index
	 */
	public abstract File getFileForBadFanoutTable();

	/**
	 * Verify CRC32 support.
	 *
	 * @throws MissingObjectException
	 *             object is missing in the underlying index
	 * @throws UnsupportedOperationException
	 *             the index doesn't have CRC
	 */
	public abstract void testCRC32() throws MissingObjectException,
			UnsupportedOperationException;

	/**
	 * Test contracts of Iterator methods and this implementation remove()
	 * limitations.
	 */
	@Test
	public void testIteratorMethodsContract() {
		Iterator<PackIndex.MutableEntry> iter = smallIdx.iterator();
		while (iter.hasNext()) {
			iter.next();
		}

		try {
			iter.next();
			fail("next() unexpectedly returned element");
		} catch (NoSuchElementException x) {
			// expected
		}

		try {
			iter.remove();
			fail("remove() shouldn't be implemented");
		} catch (UnsupportedOperationException x) {
			// expected
		}
	}

	@Test
	public void testIteratorMutableEntryCompareTo() {
		Iterator<PackIndex.MutableEntry> iterA = smallIdx.iterator();
		Iterator<PackIndex.MutableEntry> iterB = smallIdx.iterator();

		MutableEntry aEntry = iterA.next();
		iterB.next();
		MutableEntry bEntry = iterB.next();
		// b is one ahead
		assertTrue(aEntry.compareBySha1To(bEntry) < 0);
		assertTrue(bEntry.compareBySha1To(aEntry) > 0);

		// advance a, now should be equal
		assertEquals(0, iterA.next().compareBySha1To(bEntry));
	}

	@Test
	public void testIteratorMutableEntryCopyTo() {
		Iterator<PackIndex.MutableEntry> it = smallIdx.iterator();

		MutableObjectId firstOidCopy = new MutableObjectId();
		MutableEntry next = it.next();
		next.copyOidTo(firstOidCopy);
		ObjectId firstImmutable = next.toObjectId();

		MutableEntry second = it.next();

		// The copy has the right value after "next"
		assertTrue(firstImmutable.equals(firstOidCopy));
		assertFalse("iterator has moved",
				second.toObjectId().equals(firstImmutable));
	}

	/**
	 * Test results of iterator comparing to content of well-known (prepared)
	 * small index.
	 */
	@Test
	public void testIteratorReturnedValues1() {
		Iterator<PackIndex.MutableEntry> iter = smallIdx.iterator();
		assertEquals("4b825dc642cb6eb9a060e54bf8d69288fbee4904",
				iter.next().name());
		assertEquals("540a36d136cf413e4b064c2b0e0a4db60f77feab",
				iter.next().name());
		assertEquals("5b6e7c66c276e7610d4a73c70ec1a1f7c1003259",
				iter.next().name());
		assertEquals("6ff87c4664981e4397625791c8ea3bbb5f2279a3",
				iter.next().name());
		assertEquals("82c6b885ff600be425b4ea96dee75dca255b69e7",
				iter.next().name());
		assertEquals("902d5476fa249b7abc9d84c611577a81381f0327",
				iter.next().name());
		assertEquals("aabf2ffaec9b497f0950352b3e582d73035c2035",
				iter.next().name());
		assertEquals("c59759f143fb1fe21c197981df75a7ee00290799",
				iter.next().name());
		assertFalse(iter.hasNext());
	}

	@Test
	public void testEntriesPositionsRamdomAccess() {
		assertEquals(4, smallIdx.findPosition(ObjectId
				.fromString("82c6b885ff600be425b4ea96dee75dca255b69e7")));
		assertEquals(7, smallIdx.findPosition(ObjectId
				.fromString("c59759f143fb1fe21c197981df75a7ee00290799")));
		assertEquals(0, smallIdx.findPosition(ObjectId
				.fromString("4b825dc642cb6eb9a060e54bf8d69288fbee4904")));
	}

	@Test
	public void testEntriesPositionsWithIteratorOrder() {
		int i = 0;
		for (MutableEntry me : smallIdx) {
			assertEquals(smallIdx.findPosition(me.toObjectId()), i);
			i++;
		}
		i = 0;
		for (MutableEntry me : denseIdx) {
			assertEquals(denseIdx.findPosition(me.toObjectId()), i);
			i++;
		}
	}

	@Test
	public void testEntriesPositionsObjectNotInPack() {
		assertEquals(-1, smallIdx.findPosition(ObjectId.zeroId()));
		assertEquals(-1, smallIdx.findPosition(ObjectId
				.fromString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")));
	}

	/**
	 * Compare offset from iterator entries with output of findOffset() method.
	 */
	@Test
	public void testCompareEntriesOffsetsWithFindOffsets() {
		for (MutableEntry me : smallIdx) {
			assertEquals(smallIdx.findOffset(me.toObjectId()), me.getOffset());
		}
		for (MutableEntry me : denseIdx) {
			assertEquals(denseIdx.findOffset(me.toObjectId()), me.getOffset());
		}
	}

	@Test
	public void testEntriesOffsetsObjectNotInPack() {
		assertEquals(-1, smallIdx.findOffset(ObjectId.zeroId()));
		assertEquals(-1, smallIdx.findOffset(ObjectId
				.fromString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")));
	}

	/**
	 * Compare offset from iterator entries with output of getOffset() method.
	 */
	@Test
	public void testCompareEntriesOffsetsWithGetOffsets() {
		int i = 0;
		for (MutableEntry me : smallIdx) {
			assertEquals(smallIdx.getOffset(i++), me.getOffset());
		}
		int j = 0;
		for (MutableEntry me : denseIdx) {
			assertEquals(denseIdx.getOffset(j++), me.getOffset());
		}
	}

	/**
	 * Test partial results of iterator comparing to content of well-known
	 * (prepared) dense index, that may need multi-level indexing.
	 */
	@Test
	public void testIteratorReturnedValues2() {
		Iterator<PackIndex.MutableEntry> iter = denseIdx.iterator();
		while (!iter.next().name()
				.equals("0a3d7772488b6b106fb62813c4d6d627918d9181")) {
			// just iterating
		}
		assertEquals("1004d0d7ac26fbf63050a234c9b88a46075719d3",
				iter.next().name()); // same level-1
		assertEquals("10da5895682013006950e7da534b705252b03be6",
				iter.next().name()); // same level-1
		assertEquals("1203b03dc816ccbb67773f28b3c19318654b0bc8",
				iter.next().name());
	}

	@Test
	public void testBadFanoutTable() {
		IOException ex = assertThrows(IOException.class, () -> {
			try (FileInputStream fis = new FileInputStream(
					getFileForBadFanoutTable())) {
				PackIndex.read(fis);
			}
		});
		assertEquals(JGitText.get().indexFileIsTooLargeForJgit,
				ex.getMessage());
	}
}
