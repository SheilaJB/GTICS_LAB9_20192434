package org.example.lab09_20192434.Repository;

import org.example.lab09_20192434.Entity.FavoriteCoctel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FavoriteCoctelRepository extends JpaRepository<FavoriteCoctel, Integer> {
}
