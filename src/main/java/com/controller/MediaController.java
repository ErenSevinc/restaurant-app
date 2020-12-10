package com.controller;

import com.DTO.MediaDTO;
import com.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/file")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping("/list")
    public List<MediaDTO> getFiles(){
        return mediaService.getFiles();
    }

    @PostMapping("/add")
    public String addFile(@RequestParam("file")MultipartFile file, @RequestParam String imageName) throws IOException{
        return mediaService.addFile(file,imageName);
    }





}
