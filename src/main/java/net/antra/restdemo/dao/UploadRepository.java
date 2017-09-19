package net.antra.restdemo.dao;

import net.antra.restdemo.Entity.UploadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadRepository extends JpaRepository<UploadModel,Integer> {

}
