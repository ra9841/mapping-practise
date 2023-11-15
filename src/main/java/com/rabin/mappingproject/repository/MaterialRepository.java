package com.rabin.mappingproject.repository;

import com.rabin.mappingproject.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {
    Optional<Material> findByMaterialName(String materialName);

    Optional<Material> findByMaterialId(Long materialId);
}
