load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "args4j",
    visibility = [
        "//org.eclipse.jgit.pgm:__pkg__",
        "//org.eclipse.jgit.pgm.test:__pkg__",
    ],
    exports = ["@args4j//jar"],
)

java_library(
    name = "commons-compress",
    visibility = [
        "//org.eclipse.jgit.archive:__pkg__",
        "//org.eclipse.jgit.pgm.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@commons-compress//jar"],
)

java_library(
    name = "commons-lang3",
    visibility = [
        "//org.eclipse.jgit.archive:__pkg__",
        "//org.eclipse.jgit.pgm.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@commons-lang3//jar"],
)

java_library(
    name = "commons-io",
    visibility = [
        "//org.eclipse.jgit.archive:__pkg__",
        "//org.eclipse.jgit.pgm.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@commons-io//jar"],
)

java_library(
    name = "commons-codec",
    visibility = [
        "//org.eclipse.jgit:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@commons-codec//jar"],
)

java_library(
    name = "commons-logging",
    visibility = ["//visibility:public"],
    exports = ["@commons-logging//jar"],
)

java_library(
    name = "gson",
    visibility = [
        "//org.eclipse.jgit.lfs:__pkg__",
        "//org.eclipse.jgit.lfs.server:__pkg__",
    ],
    exports = ["@gson//jar"],
)

java_library(
    name = "httpclient",
    visibility = [
        "//org.eclipse.jgit.http.apache:__pkg__",
        "//org.eclipse.jgit.lfs.server.test:__pkg__",
        "//org.eclipse.jgit.pgm:__pkg__",
    ],
    exports = ["@httpclient//jar"],
)

java_library(
    name = "httpcore",
    visibility = [
        "//org.eclipse.jgit.http.apache:__pkg__",
        "//org.eclipse.jgit.http.test:__pkg__",
        "//org.eclipse.jgit.lfs.server:__pkg__",
        "//org.eclipse.jgit.lfs.server.test:__pkg__",
        "//org.eclipse.jgit.pgm:__pkg__",
    ],
    exports = ["@httpcore//jar"],
)

java_library(
    name = "sshd-osgi",
    visibility = [
        "//org.eclipse.jgit.junit.ssh:__pkg__",
        "//org.eclipse.jgit.ssh.apache:__pkg__",
        "//org.eclipse.jgit.ssh.apache.agent:__pkg__",
        "//org.eclipse.jgit.ssh.apache.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@sshd-osgi//jar"],
)

java_library(
    name = "sshd-sftp",
    visibility = [
        "//org.eclipse.jgit.junit.ssh:__pkg__",
        "//org.eclipse.jgit.ssh.apache:__pkg__",
        "//org.eclipse.jgit.ssh.apache.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@sshd-sftp//jar"],
)

java_library(
    name = "jna",
    visibility = [
        "//org.eclipse.jgit.ssh.apache.agent:__pkg__",
    ],
    exports = ["@jna//jar"],
)

java_library(
    name = "jna-platform",
    visibility = [
        "//org.eclipse.jgit.ssh.apache.agent:__pkg__",
    ],
    exports = ["@jna-platform//jar"],
)

java_library(
    name = "javaewah",
    visibility = ["//visibility:public"],
    exports = ["@javaewah//jar"],
)

java_library(
    name = "jetty-http",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-http//jar"],
    runtime_deps = [":commons-codec"],
)

java_library(
    name = "jetty-io",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-io//jar"],
)

java_library(
    name = "jetty-security",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-security//jar"],
)

java_library(
    name = "jetty-session",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-session//jar"],
)

java_library(
    name = "jetty-server",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-server//jar"],
)

java_library(
    name = "jetty-servlet",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = [
        "@jetty-servlet//jar",
        "@jetty-util-ajax//jar",
    ],
)

java_library(
    name = "jetty-util",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-util//jar"],
)

java_library(
    name = "jetty-ee10-nested",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-ee10-nested//jar"],
)

java_library(
    name = "jetty-ee10-security",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-ee10-security//jar"],
)

java_library(
    name = "jetty-ee10-servlet",
    # TODO: This should be testonly but org.eclipse.jgit.pgm depends on it.
    visibility = ["//visibility:public"],
    exports = ["@jetty-ee10-servlet//jar"],
)

java_library(
    name = "jsch",
    visibility = [
        "//org.eclipse.jgit.junit.ssh:__pkg__",
        "//org.eclipse.jgit.ssh.jsch:__pkg__",
        "//org.eclipse.jgit.ssh.jsch.test:__pkg__",
    ],
    exports = ["@jsch//jar"],
)

java_library(
    name = "bcpg",
    visibility = [
        "//org.eclipse.jgit.gpg.bc:__pkg__",
        "//org.eclipse.jgit.gpg.bc.test:__pkg__",
        "//org.eclipse.jgit.ssh.apache:__pkg__",
        "//org.eclipse.jgit.ssh.apache.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@bcpg//jar"],
)

java_library(
    name = "bcprov",
    visibility = [
        "//org.eclipse.jgit.gpg.bc:__pkg__",
        "//org.eclipse.jgit.gpg.bc.test:__pkg__",
        "//org.eclipse.jgit.ssh.apache:__pkg__",
        "//org.eclipse.jgit.ssh.apache.test:__pkg__",
        "//org.eclipse.jgit.ssh.jsch.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@bcprov//jar"],
)

java_library(
    name = "bcutil",
    visibility = [
        "//org.eclipse.jgit.gpg.bc:__pkg__",
        "//org.eclipse.jgit.gpg.bc.test:__pkg__",
        "//org.eclipse.jgit.ssh.apache:__pkg__",
        "//org.eclipse.jgit.ssh.apache.test:__pkg__",
        "//org.eclipse.jgit.ssh.jsch.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@bcutil//jar"],
)

java_library(
    name = "bcpkix",
    visibility = [
        "//org.eclipse.jgit.gpg.bc:__pkg__",
        "//org.eclipse.jgit.ssh.apache:__pkg__",
        "//org.eclipse.jgit.ssh.apache.test:__pkg__",
        "//org.eclipse.jgit.ssh.jsch.test:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@bcpkix//jar"],
)

java_library(
    name = "jzlib",
    visibility = [
        "//org.eclipse.jgit.ssh.jsch:__pkg__",
        "//org.eclipse.jgit.test:__pkg__",
    ],
    exports = ["@jzlib//jar"],
)

java_library(
    name = "junit",
    testonly = 1,
    visibility = ["//visibility:public"],
    exports = [
        "@bytebuddy-agent//jar",
        "@bytebuddy//jar",
        "@hamcrest//jar",
        "@junit//jar",
        "@mockito//jar",
        "@objenesis//jar",
    ],
)

java_library(
    name = "mockito",
    testonly = 1,
    visibility = ["//visibility:public"],
    exports = [
        "@bytebuddy-agent//jar",
        "@bytebuddy//jar",
        "@mockito//jar",
        "@objenesis//jar",
    ],
)

java_library(
    name = "assertj-core",
    testonly = 1,
    visibility = ["//visibility:public"],
    exports = [
        "@assertj-core//jar",
    ],
)

java_library(
    name = "servlet-api",
    visibility = [
        "//org.eclipse.jgit.http.apache:__pkg__",
        "//org.eclipse.jgit.http.server:__pkg__",
        "//org.eclipse.jgit.http.test:__pkg__",
        "//org.eclipse.jgit.junit.http:__pkg__",
        "//org.eclipse.jgit.lfs.server:__pkg__",
        "//org.eclipse.jgit.lfs.server.test:__pkg__",
        "//org.eclipse.jgit.pgm:__pkg__",
    ],
    exports = ["@servlet-api//jar"],
)

java_library(
    name = "slf4j-api",
    visibility = ["//visibility:public"],
    exports = ["@log-api//jar"],
)

java_library(
    name = "slf4j-simple",
    visibility = ["//visibility:public"],
    exports = ["@slf4j-simple//jar"],
)

java_library(
    name = "xz",
    testonly = 1,
    visibility = ["//visibility:public"],
    exports = ["@tukaani-xz//jar"],
)
