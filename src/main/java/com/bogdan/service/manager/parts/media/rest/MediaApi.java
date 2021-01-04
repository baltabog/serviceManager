package com.bogdan.service.manager.parts.media.rest;

import com.bogdan.service.manager.parts.media.model.MediaDTO;
import com.bogdan.service.manager.parts.media.service.MediaService;
import com.bogdan.service.manager.parts.media.transformer.MediaTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/api/media")
@RequiredArgsConstructor
public class MediaApi {
    private final MediaService mediaService;
    private final MediaTransformer mediaTransformer;

    @GetMapping("/")
    public List<MediaDTO> getAllMediaFiles() {
        return mediaTransformer.fromListOfEntityToDTO(mediaService.getAll());
    }

    @GetMapping("/{id}")
    public @ResponseBody byte[] getMediaFile(@PathVariable long id) throws IOException {
        return mediaService.getMediaFileById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MediaDTO create(@RequestBody MultipartFile multipartFile) throws IOException {
        return mediaTransformer.fromEntityToDTO(mediaService.createFromFile(multipartFile));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean create(@PathVariable long id) {
        return mediaService.delete(id);
    }
}
