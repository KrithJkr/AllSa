package com.cpe.wongnai_server.Repository;

import com.cpe.wongnai_server.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    Ingredient findByText(String text);
}
