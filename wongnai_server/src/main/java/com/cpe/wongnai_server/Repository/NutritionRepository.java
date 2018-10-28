package com.cpe.wongnai_server.Repository;
import java.util.List;

import com.cpe.wongnai_server.entity.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface NutritionRepository extends JpaRepository<Nutrition, Long> {
    Nutrition findByProtein(String protein);
    Nutrition findByCarbohydrate(String carbohydrate);
    Nutrition findByVitamin(String vitamin);
    Nutrition findByFruit(String fruit);
    Nutrition findByFat(String fat);

}
