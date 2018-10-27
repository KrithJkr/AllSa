package com.cpe.wongnai_server;
import java.util.stream.Stream;

import com.cpe.wongnai_server.Repository.*;
import com.cpe.wongnai_server.entity.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class WongnaiServerApplication {
public static void main(String[] args) {
		SpringApplication.run(WongnaiServerApplication.class, args);
	}
    @Bean
    ApplicationRunner init(CategoriesRepository categoriesRepository,MeatRepository meatRepository,CookingRepository cookingRepository,
    MemberRepository memberRepository,MenuRepository menuRepository,CommentRepository CommentRepository,
    RestaurantRepository RestaurantRepository,RatingRepository RatingRepository,ResCategoryRepository ResCategoryRepository,
    DiscountRepository DiscountRepository,DisCategoryRepository DisCategoryRepository,CouponRepository CouponRepository) {
        return args ->{

            Stream.of( "percent","amount","code" ,"other").forEach(Type -> {
                DisCategory disCategory = new DisCategory();
                disCategory.setType(Type);
                DisCategoryRepository.save(disCategory);
            });

            Stream.of("Rice", "Grill").forEach(categoryName -> {
                ResCategory category = new ResCategory();
                category.setCategoryName(categoryName);
                ResCategoryRepository.save(category);
            });

            ResCategoryRepository.findAll().forEach(System.out::println);

            Stream.of(1L,2L,3L,4L,5L).forEach(ratinglevel -> {
                Rating rating = new Rating();
                rating.setRatinglevel(ratinglevel);
                RatingRepository.save(rating);
            });

            Stream.of("ABC","DEF","GHT","HIJ","KLM").forEach(code -> {
                Coupon coupon = new Coupon();
                coupon.setCode(code);
                CouponRepository.save(coupon);
            });
            
            CouponRepository.findAll().forEach(System.out::println);

            Stream.of("Clean Food", "Normal Food", "Fast Food", "Fine Dinning").forEach(catName -> {
                Categories cat = new Categories();
                cat.setCatName(catName);
               categoriesRepository.save(cat);
            });
            categoriesRepository.findAll().forEach(System.out::println);
            Stream.of("Fish", "Pork", "Chicken", "Beef").forEach(meatName -> {
              Meat  meat = new Meat();
              meat.setMeatName(meatName);
              meatRepository.save(meat);
          });
            meatRepository.findAll().forEach(System.out::println);
            Stream.of("Pheekay", "Threerapat", "Anan", "Thotsaphon").forEach(memberName -> {
              Member member = new Member();
              member.setUsername(memberName);
              memberRepository.save(member);
              if(memberName == "Pheekay"){
                member.setPassword("1111");
                memberRepository.save(member);
              }
              if(memberName == "Threerapat"){
                member.setPassword("2222");
                memberRepository.save(member);
              }
              if(memberName == "Anan"){
                member.setPassword("3333");
                memberRepository.save(member);
              }
              if(memberName == "Thotsaphon"){
                member.setPassword("4444");
                memberRepository.save(member);
              }
          });
         memberRepository.findAll().forEach(System.out::println);
         Stream.of("พักปลาสดไว้ในอุณหภูมิห้องราว 1 ชั่วโมง ให้น้ำในตัวปลาระเหยออกแล้วโรยเกลือลงบนตัวปลาทั้ง 2 ด้านอุ่นกระทะสแตนเลสให้บนเตาให้ร้อนจัด ใส่น้ำมัน 1 ช้อนโต๊ะ และเกลือ 1 หยิบมือลงไปคั่วจนน้ำมันร้อนเป็นไอ ค่อยเทน้ำมันออกและเช็ดผิวกระทะด้วยผ้าสะอาด กระทะจะลื่นไม่ติดหนังปลาเทน้ำมันลงกระทะอีกครั้ง รอจนน้ำมันเดือด ค่อยใส่ปลาลงไปทอดด้วยไฟปานกลาง หากต้องการให้ปลากรอบมาก ต้องใส่น้ำมันเยอะท่วมตัวปลาอย่าพลิกปลาบ่อยๆ  รอให้สุกทีละด้านค่อยพลิก ปลาทอดจะสวยงามไม่ขาดแยกชิ้นพักปลาบนกระดาษซับน้ำมันสักครู่ก่อนเสิร์ฟร้อนๆ พร้อมซอสและเครื่องเคียงตามใจชอบ"
         ).forEach(cookingName -> {
         Cooking cooking = new Cooking();
         cooking.setCookingName(cookingName);
         cookingRepository.save(cooking);

         });
       cookingRepository.findAll().forEach(System.out::println);

      Menu menu = new Menu();
       menu.setMenuName("ปลาทอด");
       menu.setPicUrl("https://image.ibb.co/czMyLf/image.jpg");
       menu.setMeatId(meatRepository.getOne(1L));
       menu.setCatId(categoriesRepository.getOne(2L));
       menu.setMemberId(memberRepository.getOne(1L));
       menu.setCookingId(cookingRepository.getOne(1L));
       menuRepository.save(menu);

        Stream.of("KorKok", "KaoGang").forEach(restaurantName -> {
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantName(restaurantName);
            RestaurantRepository.save(restaurant);
            if (restaurantName == "KorKok") {
                restaurant.setAddress("SUT GATE 1");
                restaurant.setRestaurantImg("https://s3-ap-southeast-1.amazonaws.com/wekorat/wp-content/uploads/2014/11/19160638/IMG_4445-600x450.jpg");
                restaurant.setCategories(ResCategoryRepository.getOne(2L));
                RestaurantRepository.save(restaurant);
            } else if (restaurantName == "KaoGang") {
                restaurant.setAddress("SUT GATE 4");
                restaurant.setRestaurantImg("https://s3-ap-southeast-1.amazonaws.com/wekorat/wp-content/uploads/2014/11/19160638/IMG_4445-600x450.jpg");
                restaurant.setCategories(ResCategoryRepository.getOne(1L));
                RestaurantRepository.save(restaurant);
            }
            RestaurantRepository.findAll().forEach(System.out::println);
        });

        Comment comment = new Comment();
            comment.setMembers(memberRepository.getOne(1L));
            comment.setText(" Hello Comment for KorKok :)");
          comment.setImg("https://thepaperglow.files.wordpress.com/2015/06/wpid-pizza-junk-food-600.jpg");            comment.setRestaurants(RestaurantRepository.getOne(1L));
            comment.setRating(RatingRepository.getOne(5L));
            CommentRepository.save(comment);


          Comment comment2 = new Comment();
          comment2.setMembers(memberRepository.getOne(2L));
          comment2.setRating(RatingRepository.getOne(3L));
          comment2.setImg("http://www.pubwages.com/wp-content/uploads/2011/06/junk-food-008.jpg");
          comment2.setText("YoYo Comment for KorKok >,<");
          comment2.setRestaurants(RestaurantRepository.getOne(1L));
          CommentRepository.save(comment2);

          Comment comment3 = new Comment();
          comment3.setMembers(memberRepository.getOne(2L));
          comment3.setRating(RatingRepository.getOne(5L));
          comment3.setImg("https://foodimentaryguy.files.wordpress.com/2014/11/healthfitnessrevolution-com.jpg");
          comment3.setText("Hi Comment for KaoGang :D");
          comment3.setRestaurants(RestaurantRepository.getOne(2L));
          CommentRepository.save(comment3);


          Comment comment4 = new Comment();
          comment4.setMembers(memberRepository.getOne(1L));
          comment4.setRating(RatingRepository.getOne(2L));
          comment4.setImg("http://www.pubwages.com/wp-content/uploads/2011/06/junk-food-008.jpg");
          comment4.setText("Yeah Comment for KaoGang :<");
          comment4.setRestaurants(RestaurantRepository.getOne(2L));
          CommentRepository.save(comment4);

        CommentRepository.findAll().forEach(System.out::println);

        Stream.of("buy one get one","50% off!","5% off with Holiday Coupon!").forEach(Name -> {
            Discount discount = new Discount();
            discount.setName(Name);
            DiscountRepository.save(discount);
            if (Name == "buy one get one") {
                discount.setTitle("purchase 1 get free 1");
                discount.setDiscountCategory(DisCategoryRepository.getOne(4L));
                discount.setDiscountRestaurant(RestaurantRepository.getOne(1L));
                DiscountRepository.save(discount);
            } 
            if (Name == "50% off!") {
                discount.setTitle("you can buy product in half price");
                discount.setDiscountCategory(DisCategoryRepository.getOne(1L));
                discount.setDiscountRestaurant(RestaurantRepository.getOne(2L));
                DiscountRepository.save(discount);
            } 
            if (Name == "5% off with Holiday Coupon!") {
                discount.setTitle("just show coupon code to earn 5% discount");
                discount.setDiscountCategory(DisCategoryRepository.getOne(3L));
                discount.setDiscountRestaurant(RestaurantRepository.getOne(2L));
                DiscountRepository.save(discount);
            } 
            DiscountRepository.findAll().forEach(System.out::println);
        });
        
            
    };  }
}








