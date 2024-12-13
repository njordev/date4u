package com.tutego.date4u.service;

import java.io.UncheckedIOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {

    private final FileSystem fs;
    private final Thumbnail thumbnail;

    public PhotoService(FileSystem fs, @Qualifier("fastThumbnailRenderer") Thumbnail thumbnail) {
        this.fs = fs;
        this.thumbnail = thumbnail;
    }

    public Optional<byte[]> download(String name) {
        try {
            return Optional.of(fs.load(name + ".jpeg"));
        } catch (UncheckedIOException e) {
            return Optional.empty();
        }
    }

    public String upload(byte[] imageBytes) {
        String imageName = UUID.randomUUID().toString();
        // Originalbild speichern
        fs.store(imageName + ".jpg", imageBytes);
        // Thumbnail erstellen und speichern
        byte[] thumbnailBytes = thumbnail.thumbnail(imageBytes);
        fs.store(imageName + "thumb.jpg", thumbnailBytes);
        return imageName;
    }
}
