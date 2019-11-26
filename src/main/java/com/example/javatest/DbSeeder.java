package com.example.javatest;

import com.example.javatest.Service.DbSeederService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class DbSeeder implements ApplicationListener<ApplicationReadyEvent> {

    private DbSeederService dbSeederService;

    public DbSeeder(DbSeederService dbSeederService) {
        this.dbSeederService = dbSeederService;
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        Path path =  Paths.get("dbSeedFlag");
        try {
            if(!Files.exists(path)) {
                Files.createFile(path);
                dbSeederService.seedDB();
            }
        } catch (Exception fileFiledToCreat) {
             System.out.println(fileFiledToCreat.getMessage());
        }
    }
}
