package com.nhom1.java6.restcontroller;

import com.nhom1.java6.service.Filemanager;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/file")
public class FileRestController {
    @Autowired
    Filemanager filemanager;

    @RequestMapping("{folder}/{file}")
    public byte[] download(@PathVariable("folder") String folder, @PathVariable("file") String file){

        return filemanager.read(folder,file);
    }

    @PostMapping("{folder}")
    public List<String> upload(@PathVariable("folder") String folder, @PathParam("files") MultipartFile[] files){

        return filemanager.save(folder,files);
    }

    @DeleteMapping("{folder}/{file}")
    public void  delete(@PathVariable("folder") String folder,@PathVariable("file") String file){
        filemanager.delete(folder,file);

    }

    @GetMapping("{folder}")
    public List<String>  list(@PathVariable("folder") String folder){
        return filemanager.list(folder);
    }
}
