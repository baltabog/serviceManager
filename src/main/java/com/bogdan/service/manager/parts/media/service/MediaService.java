package com.bogdan.service.manager.parts.media.service;

import com.bogdan.service.manager.common.database.CrudService;
import com.bogdan.service.manager.parts.media.model.Media;
import com.bogdan.service.manager.parts.media.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MediaService extends CrudService<Media, MediaRepository> {
    private final MediaRepository companyRepository;

    @Override
    protected MediaRepository getRepository() {
        return companyRepository;
    }

    public byte[] getMediaFileById(long id) throws IOException {
        Media media = companyRepository.findById(id).orElseThrow();
        File file = getFileFromMediaEntity(media).getCanonicalFile();
        byte[] bytes = new byte[(int) file.length()];

        try(FileInputStream fis = new FileInputStream(file)){
            fis.read(bytes);
        }

        return bytes;
    }

    public Media createFromFile(MultipartFile multipartFile) throws IOException {
        Media media = getMediaEntityFromMultipartFile(multipartFile);
        writeFileFromMultipartFile(media, multipartFile);

        return companyRepository.save(media);
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        Optional<Media> mediaOptional = getRepository().findById(id);
        if (mediaOptional.isPresent()) {
            Media media = mediaOptional.get();
            getRepository().delete(media);
            return getFileFromMediaEntity(media).delete();
        }

        return false;
    }

    private File getFileFromMediaEntity(Media media) {
        return getFileCompletePathFromMedia(media).toFile();
    }

    private Media getMediaEntityFromMultipartFile(MultipartFile file) {
        Media media = new Media();
        media.setPath(getFilePath());
        media.setName(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssSSSSS")));
        media.setType(MediaType.parseMediaType(file.getContentType()));
        media.setSize(file.getSize());

        return media;
    }

    private void writeFileFromMultipartFile(Media media, MultipartFile multipartFile) throws IOException {
        Path filepath = getFileCompletePathFromMedia(media);
        multipartFile.transferTo(filepath);
    }

    private String getFilePath() {
        return Paths.get("").toAbsolutePath().toString();
    }

    private Path getFileCompletePathFromMedia(Media media) {
        return Paths.get(media.getPath() + File.separator + "store" + File.separator + media.getName());
    }

}
