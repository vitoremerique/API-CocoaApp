package com.api.cocoa.repository;



import com.api.cocoa.file.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FileRepository extends JpaRepository<FileEntity, String> {
}
