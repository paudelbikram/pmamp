package com.grind75.common;

public class VersionControl {

    private final int numberOfVersions;
    private final int firstBadVersion;

    public VersionControl(int numberOfVersions, int firstBadVersion) {
        this.numberOfVersions = numberOfVersions;
        this.firstBadVersion = firstBadVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= firstBadVersion && version <= numberOfVersions;
    }

    public int getNumberOfVersions() {
        return numberOfVersions;
    }

    public int getFirstBadVersion() {
        return firstBadVersion;
    }
}
