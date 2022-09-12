package com.example.classwork3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> students = new ArrayList<>();
    int currentstudent=0;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            context = this;
        TextView studentName , studentAge , studentGrade;
        ImageView studentImg;
        Button changeStudentBtn;

        studentName = findViewById(R.id.studentname);
        studentAge = findViewById(R.id.studentAge);
        studentImg = findViewById(R.id.imageView);
        studentGrade = findViewById(R.id.studentGrade);
        changeStudentBtn = findViewById(R.id.button);

        Student firstStudent = new Student ("sara khaled",19,79,R.drawable.first);
        Student secondStudent = new Student ("yousef ahmed ",20,85,R.drawable.youseff);
        Student thirdStudent = new Student ("majed salman",18,99,R.drawable.majed);


        students.add(firstStudent);
        students.add(secondStudent);
        students.add(thirdStudent);

        studentName.setText(students.get(currentstudent).getStudentName());
        studentAge.setText(students.get(currentstudent).getStudentAge()+"");
        studentGrade.setText(students.get(currentstudent).getStudentGrade()+"");
        studentImg.setImageResource(students.get(currentstudent).getStudentImg());

        changeStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentstudent++;
                if(currentstudent==students.size()){
                    Toast.makeText(context,"its the end of the list",Toast.LENGTH_SHORT).show();
                    currentstudent = 0;
                }
                studentName.setText(students.get(currentstudent).getStudentName());
                studentAge.setText(students.get(currentstudent).getStudentAge()+"");
                studentGrade.setText(students.get(currentstudent).getStudentGrade()+"");
                studentImg.setImageResource(students.get(currentstudent).getStudentImg());
            }
        });


    }
}