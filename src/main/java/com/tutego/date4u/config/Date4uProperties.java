package com.tutego.date4u.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("date4u")
public class Date4uProperties {

    // Innere Klasse für Filesystem-Eigenschaften
    public static class Filesystem {
        private long minimumFreeDiskSpace = 1_000_000;

        // Getter
        public long getMinimumFreeDiskSpace() {
            return minimumFreeDiskSpace;
        }

        // Setter
        public void setMinimumFreeDiskSpace(long minimumFreeDiskSpace) {
            this.minimumFreeDiskSpace = minimumFreeDiskSpace;
        }
    }

    private Filesystem filesystem = new Filesystem();

    // Getter
    public Filesystem getFilesystem() {
        return filesystem;
    }

    // Setter
    public void setFilesystem(Filesystem filesystem) {
        this.filesystem = filesystem;
    }
}
