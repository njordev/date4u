package com.tutego.date4u.shell;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import com.tutego.date4u.service.FileSystem;

@ShellComponent
public class FsCommands {

    private final FileSystem fs;
    private Environment env;

    public FsCommands( FileSystem fs ) {
        this.fs = fs;
    }
    @Value("${date4u.filesystem.minimum-free-disk-space:1000000}")
    private long minimumFreeDiskSpace;

    @ShellMethod("Display free disk space")
    public long minimumFreeDiskSpace() {
        return minimumFreeDiskSpace;
    }

    @ShellMethod("Display user home")
    public String userHome() {
        return env.getProperty( "user.home" );
    }
}
