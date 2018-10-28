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
    DiscountRepository DiscountRepository,DisCategoryRepository DisCategoryRepository,CouponRepository CouponRepository,AddressRepository addressRepository,
    CreditcardRepository creditcardRepository, ProfileRepository profileRepository,IngredientRepository ingredientrepository,
    InfoMenuRepository infomenurepository,NutritionRepository nutritionrepository,StoryRepository storyrepository) {
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

            Stream.of("Pae","Nay","Phee","Best","Copter","Jump").forEach(username -> {
              Member member = new Member();
              member.setUsername(username);
              memberRepository.save(member);
            if (username == "Pae") {
                member.setPassword("111");
                member.setEmail("pae_tawee@hotmail.co.th");
                member.setMemberOf("FACEBOOK");
            }
            else if (username == "Nay") {
                member.setPassword("222");
                member.setEmail("Nay@hotmail.com");
                member.setMemberOf("FACEBOOK");
            }
            else if (username == "Copter") {
                member.setPassword("333");
                member.setEmail("Ter@gmail.com");
                member.setMemberOf("GOOGLE");
            }
            else if (username == "Phee") {
                member.setPassword("444");
                member.setEmail("Pee@hotmail.com");
                member.setMemberOf("GOOGLE");
            }
            else if (username == "Jump") {
                member.setPassword("555");
                member.setEmail("JJp@gmail.co.th");
                member.setMemberOf("GOOGLE");
            }
            else if (username == "Best") {
                member.setPassword("666");
                member.setEmail("Best@hotmail.com");
                member.setMemberOf("FACEBOOK");
            }
            memberRepository.save(member);


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
                restaurant.setRtel("055296214");
                restaurant.setMenus(menuRepository.getOne(1L));
                restaurant.setMemberowner(memberRepository.getOne(1L));
                restaurant.setRestaurantImg("https://s3-ap-southeast-1.amazonaws.com/wekorat/wp-content/uploads/2014/11/19160638/IMG_4445-600x450.jpg");
                restaurant.setCategories(ResCategoryRepository.getOne(2L));
                RestaurantRepository.save(restaurant);
            } else if (restaurantName == "KaoGang") {
                restaurant.setAddress("SUT GATE 4");
                restaurant.setRtel("055296214");
                restaurant.setMenus(menuRepository.getOne(1L));
                restaurant.setMemberowner(memberRepository.getOne(2L));
                restaurant.setRestaurantImg("https://www.scb.co.th/content/dam/scb/personal-banking/stories-tips/rice-index/80w_696645559.jpg");
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
                discount.setDiscountrestaurant(RestaurantRepository.getOne(1L));
                DiscountRepository.save(discount);
            }
            if (Name == "50% off!") {
                discount.setTitle("you can buy product in half price");
                discount.setDiscountCategory(DisCategoryRepository.getOne(1L));
                discount.setDiscountrestaurant(RestaurantRepository.getOne(2L));
                DiscountRepository.save(discount);
            }
            if (Name == "5% off with Holiday Coupon!") {
                discount.setTitle("just show coupon code to earn 5% discount");
                discount.setDiscountCategory(DisCategoryRepository.getOne(3L));
                discount.setDiscountrestaurant(RestaurantRepository.getOne(2L));
                DiscountRepository.save(discount);
            }
            DiscountRepository.findAll().forEach(System.out::println);
        });

        Stream.of("BBL","BBC","KTB","BAY","KBANK","CITI","TMB","SCB","NBANK","SCIB","GSB","GHB").forEach(bank ->{
            Creditcard creditcard = new Creditcard();
                creditcard.setBank(bank);
            creditcardRepository.save(creditcard);
        });
        creditcardRepository.findAll().forEach(System.out::println);

        Stream.of("Nakhonratchasima","Phitsanulok","Chiang Rai","Chiang Mai","Kalasin","Khon Kaen","Chaiyaphum","Nakhon Phanom","Bueng Kan","Buri Ram","Maha Sarakham","Mukdahan",
			"Nan","Phayao","Phrae","Mae Hong Son","Lampang","Lamphun","Uttaradit","Yasothon","Roi Et","Loei","Si Sa Ket","Sakon Nakhon","Surin","Nong Khai","Nong Bua Lam Phu","Amnat Charoen"
			,"Udon Thani","Ubon Ratchathani","Kamphaeng Phet","Chai Nat","Nakhon Nayok","Nakhon Pathom","Nakhon Sawan","Nonthaburi","Pathum Thani","Phra Nakhon Si Ayutthaya","Phichit"
			,"Phetchabun","Lop Buri","Samut Prakan","Samut Songkhram","Samut Sakhon","Sing Buri","Sukhothai","Suphan Buri","Saraburi","Ang Thong","Uthai Thani","Chanthaburi","Chachoengsao"
			,"Chon Buri","Trat","Prachin Buri","Rayong","Sa Kaeo","Kanchanaburi","Tak","Prachuap Khiri Khan","Phetchaburi","Ratchaburi","Krabi","Chumphon","Trang","Nakhon Si Thammarat"
			,"Narathiwat","Pattani","Phangnga","Phatthalung","Phuket","Yala","Ranong","Songkhla","Satun","Surat Thani","Krung Thep Maha Nakhon(Bangkok Metropolis)").forEach(provine_name ->{
				Address address = new Address();
				address.setProvincename(provine_name);
				addressRepository.save(address);
			});
            addressRepository.findAll().forEach(System.out::println);

            Stream.of("Pae","Nay","Pee","Best","Copter","Jump").forEach(username ->{
				Profile profile = new Profile();
				if(username=="Pae"){
					profile.setFirstname("Thaweechai");
					profile.setLastname("Kanklang");
					profile.setAge(21l);
					Creditcard creditcard = new Creditcard();
					creditcard.setNumber(11111111L);
					creditcard.setBank("SCB");
					creditcardRepository.save(creditcard);
					profile.setCreditcard(creditcardRepository.getOne(13L));
					profile.setMember(memberRepository.getOne(1L));
					profile.setAddress(addressRepository.getOne(1L));
				}
				else if(username=="Nay"){
					profile.setFirstname("Anan");
					profile.setLastname("Noisia");
					profile.setAge(21l);
					Creditcard creditcard = new Creditcard();
					creditcard.setNumber(22222222L);
					creditcard.setBank("SCB");
					creditcardRepository.save(creditcard);
					profile.setCreditcard(creditcardRepository.getOne(14L));
					profile.setMember(memberRepository.getOne(2L));
					profile.setAddress(addressRepository.getOne(2L));
				}
				else if(username=="Pee"){
					profile.setFirstname("Krith");
					profile.setLastname("Jeenkumroeng");
					profile.setAge(21l);
					Creditcard creditcard = new Creditcard();
					creditcard.setNumber(33333333L);
					creditcard.setBank("TMB");
					creditcardRepository.save(creditcard);
					profile.setCreditcard(creditcardRepository.getOne(15L));
					profile.setMember(memberRepository.getOne(3L));
					profile.setAddress(addressRepository.getOne(77L));
				}
				else if(username=="Best"){
					profile.setFirstname("Supanat");
					profile.setLastname("Jarukulgowit");
					profile.setAge(21l);
					Creditcard creditcard = new Creditcard();
					creditcard.setNumber(44444444L);
					creditcard.setBank("TMB");
					creditcardRepository.save(creditcard);
					profile.setCreditcard(creditcardRepository.getOne(16L));
					profile.setMember(memberRepository.getOne(4L));
					profile.setAddress(addressRepository.getOne(1L));
				}
				else if(username=="Copter"){
					profile.setFirstname("Thotsaphon");
					profile.setLastname("JanTree");
					profile.setAge(21l);
					Creditcard creditcard = new Creditcard();
					creditcard.setNumber(55555555L);
					creditcard.setBank("TMB");
					creditcardRepository.save(creditcard);
					profile.setCreditcard(creditcardRepository.getOne(17L));
					profile.setMember(memberRepository.getOne(5L));
					profile.setAddress(addressRepository.getOne(23L));
				}
				else if(username=="Jump"){
					profile.setFirstname("Theeraphat");
					profile.setLastname("Jamklang");
					profile.setAge(21l);
					Creditcard creditcard = new Creditcard();
					creditcard.setNumber(6666666L);
					creditcard.setBank("TMB");
					creditcardRepository.save(creditcard);
					profile.setCreditcard(creditcardRepository.getOne(18L));
					profile.setMember(memberRepository.getOne(6L));
					profile.setAddress(addressRepository.getOne(1L));
				}
				profileRepository.save(profile);
			});
      profileRepository.findAll().forEach(System.out::println);


      //set ingredient
      Stream.of("แครอท,ไข่ต้ม,หัวหอม,กะหล่ำ","หมูสับ,ใบกะเพรา,ข้าว,ไข่ดาว","ไก่,ข้าว,กระเทียม","ปลา").forEach(ingredient_of_food-> {
        Ingredient ingredient= new Ingredient();
        ingredient.setText(ingredient_of_food);
        ingredientrepository.save(ingredient);

    });

    //set story
    Stream.of("เมื่อพูดถึง สลัด  เรามักนึกถึงเมนูผักเพื่อสุขภาพ หลายคนเลือกทาน สลัด เพื่อควบคุมน้ำหนักและระบบขับถ่ายที่ดีและมีใครทราบไหมค่ะว่าคำว่า “สลัด”มีที่มาที่ไปอย่างไรวันนี้เรามีบอกค่ะ คำว่า”สลัด” Salads มาจากภาษาฝรั่งเศส คือคำว่า Salada ซึ่งมีความหมายตรงกับภาษาละติน Salad ที่แปลว่า Salty หรือแปลว่ารสเค็มนั้นเอง ดังนั้นจึงเขียนได้อีกชื่อหนึ่งว่า Salted Herbs หรือ Herbasalta ซึ่งแปลว่า ผักที่ปรุงด้วยน้ำสลัดอันมีส่วนผสมของเกลือ กว่าจะได้เป็นว่า”สลัด”สั้นๆนี้หลากหลายที่มาเลยนะคะ เรามาดูประโยชน์ของการกินสลัดกันดีกว่าค่ะว่าจะมากมายหลากหลายเหมือนที่มาไหมนะ"
     ).forEach(story_of_food-> {
        Story story =new Story();
        story.setStext(story_of_food);
        storyrepository.save(story);

     });

    //set Ingredient
    Nutrition nutrition = new Nutrition();
    nutrition.setCarbohydrate("10%");
    nutrition.setFat("0%");
    nutrition.setFruit("30%");
    nutrition.setProtein("20%");
    nutrition.setVitamin("40%");
    nutritionrepository.save(nutrition);

        //set menu
    Stream.of("salad").forEach(menuname -> {
        InfoMenu infomenu = new InfoMenu();
        infomenu.setMenus(menuRepository.getOne(1L));
        infomenu.setStext(storyrepository.getOne(1L));
        infomenu.setCal(80.5);
        infomenu.setText(ingredientrepository.getOne(1L));
        infomenu.setNutrition(nutritionrepository.getOne(1L));

        infomenurepository.save(infomenu);
    } ); };
}};








