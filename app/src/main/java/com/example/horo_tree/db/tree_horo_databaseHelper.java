package com.example.horo_tree.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.horo_tree.R;

public class tree_horo_databaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "tree_db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_Tree_horo = "tree_horo";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_IMAGE = "image";
    public static final String COL_Tree_PIC = "Pic";
    public static final String COL_INFORMATION = "information";

    private static final String SQL_CREATE_PLACE =
            "CREATE TABLE " + TABLE_Tree_horo + " ("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NAME + " TEXT, "
                    + COL_IMAGE + " INTEGER, "
                    + COL_Tree_PIC + " INTEGER, "
                    + COL_INFORMATION + " TEXT )";

    public tree_horo_databaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PLACE);

        ContentValues cv = new ContentValues();
        cv.put(COL_NAME, "ราศีมังกร");
        cv.put(COL_IMAGE, R.drawable.capricornus);
        cv.put(COL_Tree_PIC, R.drawable.m1);
        cv.put(COL_INFORMATION, " สำหรับไม้มงคลของผู้ที่เกิดในราศีมังกรควรปลูก คือ แก้ว วาสนา โป๊ยเซียน กุหลาบ เพื่อเสริมดวงทางด้านการเงิน ช่วยให้ร่ำรวย ทำกิจการใด ๆ " +
                "ก็รุ่งเรือง เกิดโชคลาภ วาสนาให้กับตัวเอง และถ้าหากอยากเสริมดวงชะตา หรือเพิ่มความมั่นคงให้แก่ลูกหลานของคุณ ควรปลูก ต้นไผ่ ที่แสดงถึงความอดทน มีความเป็นนักสู้ และราชพฤกษ์ ที่แสดงถึงความเจริญรุ่งเรืองดั่งทอง เหมือนสีของราชพฤกษ์");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีกุมภ์");
        cv.put(COL_IMAGE, R.drawable.aquarius);
        cv.put(COL_Tree_PIC, R.drawable.m2);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดในราศีกุมภ์ควรปลูก คือ เข็ม เฟื่องฟ้า และบอนไซ ไว้ที่สวนหน้าบ้าน โรงงาน หรือบริษัทร้านค้าของตนเอง เพื่อเสริมความเป็นสิริมงคล ทำให้มั่งคั่ง เจริญรุ่งเรือง และมีชีวิตที่ยืนยาว เข็ม แสดงถึงความฉลาดหลักแหลม " +
                "เฟื่องฟ้า แสดงถึงการเสริมคุณค่าในชีวิตให้สูงขึ้น และเมื่อดอกเฟื่องฟ้าบาน เชื่อว่าจะเสริมให้ชีวิตสดใสเบิกบาน สว่าง รุ่งเรือง และความก้าวไกลในชีวิต ส่วน บอนไซ นั้นเป็นสัญลักษณ์ของความแข็งแกร่งอดทน หนักเอาเบาสู้ทุกเรื่องไม่ท้อถอย์");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีมีน");
        cv.put(COL_IMAGE, R.drawable.pisces);
        cv.put(COL_Tree_PIC, R.drawable.m3);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีมีนควรปลูก คือ กล้วยไม้ เพราะกล้วยไม้จะทำให้บุคคลที่พบเห็นประทับใจ ทำให้คนในบ้านมีจริยธรรม เหมาะกับผู้ที่มีนิสัยใจเย็น อ่อนโยน เฟื่องฟ้า แสดงถึงความรุ่งเรือง สดใสเบิกบาน วาสนา ทำให้เกิดวาสนาเหมือนชื่อต้น " +
                "มีความสุข ความสมหวัง ถือเป็นไม้มงคลเสี่ยงทาย เพราะถ้าหากปลูกออกมาสวยงาม และออกดอกแล้วล่ะก็ เชื่อว่าจะทำให้มีโชคลาภ คิดหวังสิ่งใดก็สมดังปรารถนา ส่วนไม้ที่ให้พลังอำนาจแก่คนในราศีมีน ได้แก่ โมก กล้วย และมะม่วง จะช่วยเสริมบารมี และคุ้มครองบริวารลูกหลาน");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีเมษ");
        cv.put(COL_IMAGE, R.drawable.aries);
        cv.put(COL_Tree_PIC, R.drawable.m4);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีเมษควรปลูก คือ มะยม มะขาม ทั้ง 2 ต้นนี้จะเป็นพลังช่วยหนุนให้ชาวราศีเมษประสบความสำเร็จในชีวิต รวมทั้งหน้าที่การงานด้วย มะยม ปลูกแล้วจะมีแต่คนนิยมชมชอบ ส่วน มะขาม จะทำให้มีแต่ผู้คนเกรงขาม " +
                "ให้ความนับถือ นอกจากนี้ยังมี เฟื่องฟ้า ที่จะทำให้ชีวิตของชาวราศีเมษรุ่งเรือง สว่างไสว และเบิกบานอยู่เสมอ");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีพฤษภ");
        cv.put(COL_IMAGE, R.drawable.taurus);
        cv.put(COL_Tree_PIC, R.drawable.m5);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีพฤษภควรปลูก คือ โมก เพราะดอกสีขาวของโมกเป็นตัวแทนของความบริสุทธิ์ผุดผ่อง และความเชื่อของโบราณเชื่อว่าต้นโมกสามารถคุ้มกันภัยอันตรายต่าง ๆ จากภายนอกได้ ควรปลูกทางทิศตะวันตกเฉียงเหนือของบ้าน " +
                "และควรปลูกในวันเสาร์ แก้ว ช่วยเสริมสร้างคุณธรรม คนในบ้านจะมีความดี มีคุณค่าสูง และมีโชคมีลาภ ควรปลูกในทิศตะวันออก และควรปลูกในวันพุธ และ ส้มโอ บ่งบอกถึงความอุดมสมบูรณ์");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีเมถุน");
        cv.put(COL_IMAGE, R.drawable.gemini);
        cv.put(COL_Tree_PIC, R.drawable.m6);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีเมถุนควรปลูก คือ โมก จะช่วยเสริมให้เกิดความสุข ความบริสุทธิ์สดใส เข็ม จะช่วยทำให้ชะตารุ่งเรือง อุปสรรคและปัญหาต่าง ๆ ไม่กล้ากล้ำกรายเข้ามา ควรจะปลูกไว้เป็นร่องตรงประตูบ้าน หรือสองข้างทางเดิน ทับทิม " +
                "เป็นตัวแทนของความสงบร่มเย็นในชีวิต โป๊ยเซียน ถือเป็นไม้เสี่ยงทาย ถ้าปลูกแล้วออกดอกมากกว่า 8 ดอก ผู้ปลูกและคนในบ้านจะมีโชคลาภ และยังเชื่อว่าจะช่วยคุ้มครองให้อยู่เย็นเป็นสุข กุหลาบ จะช่วยให้เกิดความสง่าภาคภูมิ ช่วยเสริมคุณค่าแห่งชีวิตให้คนในบ้านสูง");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีกรกฎ");
        cv.put(COL_IMAGE, R.drawable.cancer);
        cv.put(COL_Tree_PIC, R.drawable.m7);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีกรกฎควรปลูก คือ กล้วยไม้ จะช่วยเสริมโชคลาภให้กับผู้ปลูก เหมาะกับผู้ที่ใจเย็นและอ่อนโยนเช่นชาวราศีกรกฎ เพราะเมื่อกล้วยไม้ออกดอกแล้ว จะต้องได้รับการดูแลด้วยความตั้งใจ ดอกที่สวยงามจะทำให้ผู้ที่พบเห็นประทับใจ " +
                "และจะช่วยทำให้คนในบ้านมีจริยธรรม ชมพู่ ช่วยให้เงินทองไหลมาเทมา ทำให้ผู้ปลูกมีบุญวาสนา เกิดความสุข สมหวัง พลูด่าง ช่วยให้ร่มเย็น เป็นสุข เฟื่องฟ้า จะช่วยเสริมให้ชีวิตเบิกบาน");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีสิงห์");
        cv.put(COL_IMAGE, R.drawable.leo);
        cv.put(COL_Tree_PIC, R.drawable.m8);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีสิงห์ควรปลูก คือ ขนุน โดยโบราณเชื่อกันว่าบริเวณบ้านจะถูกหนุนด้วยบุญบารมี เงินทอง มีคนอุปถัมภ์เกื้อหนุน และอุดหนุนจุนเจือไม่ขาดสาย จำปี จะช่วยทำให้ชีวิตสดใส การงานก้าวหน้าขึ้นไปเรื่อย ๆ มีแต่ความรุ่งเรือง " +
                "ไม่มีปัญหามาย่างกราย โป๊ยเซียน เสริมความร่ำรวย รุ่งเรือง และเป็นไม้เสี่ยงทาย หากออกดอก 8 ดอก จะช่วยให้มีโชคลาภ กล้วยไม้ เมื่อกล้วยไม้ออกดอกสวย ๆ จะทำให้ผู้ที่พบเห็นประทับใจ ถึงถือเคล็ดว่าการปลูกกล้วยไม้จะทำให้เกิดความประทับใจแก่บุคคลทั่วไป");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีกันย์");
        cv.put(COL_IMAGE, R.drawable.virgo);
        cv.put(COL_Tree_PIC, R.drawable.m9);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีกันย์ควรปลูก คือ สนฉัตร ช่วยให้มีเกียรติ และสง่า ช่วยเสริมให้ได้รับความสนใจจากคนทั่วไป ควรปลูกทางทิศเหนือ และปลูกในวันเสาร์ เพื่อเสริมความเป็นสิริมงคลมากขึ้น ราชพฤกษ์ช่วยเสริมให้มีเกียรติ มีผู้อุปถัมภ์ มีศักดิ์ศรี " +
                "และบารมีมากขึ้น เฟื่องฟ้า ทำให้เกิดความสดใสเบิกบานโป๊ยเซียน เสริมดวงเรื่องการเงิน นำมาซึ่งโชคลาภ และความร่ำรวย ขนุน เป็นไม้มงคลมาตั้งแต่โบราณ เชื่อว่าจะมีคนช่วยเกื้อหนุน อุดหนุนจุนเจือ มะยม ผู้คนจะนิยมชมชอบ และนับหน้าถือตา");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีตุลย์");
        cv.put(COL_IMAGE, R.drawable.libra);
        cv.put(COL_Tree_PIC, R.drawable.m10);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีตุลย์ควรปลูก คือ หมากแดง ปาล์ม พลูด่าง โกสน จะช่วยเสริมเรื่องบุญบารมี คุ้มครองให้อยู่เย็นเป็นสุข จำปี เสริมในเรื่องของการงาน ให้การงานก้าวหน้ายิ่ง ๆ ขึ้นไป มีแต่ความรุ่งเรือง ไร้ปัญหา และอุปสรรคมาขัดขวาง " +
                "จำปา เป็นสัญลักษ์แห่งความรักมาตั้งแต่โบราณ แสดงให้เห็นถึงความรักที่มีต่อผู้อื่น ต่อญาติมิตร และจะมีแต่คนมารัก เฟิร์นข้าหลวง ทำให้้เกิดชื่อเสียงเกียรติยศ");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีพิจิก");
        cv.put(COL_IMAGE, R.drawable.scorpio);
        cv.put(COL_Tree_PIC, R.drawable.m11);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีพิจิกควรปลูก คือ พวงแสด ปาล์ม เฟื่องฟ้า แสดงถึงความสว่างไสวในชีวิต สดใสเบิกบาน เบญจมาศ ช่วยให้รุ่งเรืองมั่นคง ขนุน จะมีบารมี และมีแต่คนเกื้อหนุน มีเงินทองไม่ขาดมือ ว่านสี่ทิศ ไม่ว่าจะเดินทางไปที่ไหน " +
                "ในทิศใดก็ตามแต่ จะแคล้วคลาดปลอดภัยเสมอ และจะมีแต่คนหยิบยื่นมือเข้ามาช่วยเหลือ");
        db.insert(TABLE_Tree_horo, null, cv);

        cv = new ContentValues();
        cv.put(COL_NAME, "ราศีธนู");
        cv.put(COL_IMAGE, R.drawable.sagittarius);
        cv.put(COL_Tree_PIC, R.drawable.m12);
        cv.put(COL_INFORMATION, "สำหรับไม้มงคลของผู้ที่เกิดราศีธนูควรปลูก คือ บัว แสดงถึงความบริสุทธิ์เบิกบาน ทำให้คนในครอบครัวมีความห่วงใยผูกพันกัน เฟิร์นข้าหลวง นำมาซึ่งชื่อเสียงเกียรติยศ แก้ว ช่วยขจัดปัญหาอุปสรรคต่าง ๆ ที่เข้ามาในชีวิต พลูด่าง และโป๊ยเซียน " +
                "ปกป้องคุ้มครองให้พ้นจากภัยอันตราย ช่วยเสริมโชคลาภให้แก่ผู้ที่เกิดราศีธนู");
        db.insert(TABLE_Tree_horo, null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
