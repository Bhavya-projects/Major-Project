package com.harneet.androidattendancesystem;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Windows-10 on 9/13/2018.
 */

public interface ApiInterface {

    @POST("login_check.php")
    @FormUrlEncoded
    Call<LoginBean> savepost(@Field("uname") String username, @Field("password") String password,@Field("name") String name);


    @POST("insertTeacherDetails.php")
    @FormUrlEncoded
    Call<TeacherBean> saveteacherdetails(@Field("tname") String tname,@Field("tuname") String tusername,@Field("tpassword") String tpassword,@Field("tmno") String tmno,@Field("temail") String temail,@Field("thq") String thq);

    @POST("insertClassDetails.php")
    @FormUrlEncoded
    Call<ClassBean> saveclassdetails(@Field("course_name") String coursename, @Field("semester") String semester,@Field("teacher") String teacher);

    @POST("insertStudentDetails.php")
    @FormUrlEncoded
    Call<StudentBean> savestudentdetails(@Field("sname") String sname, @Field("suname") String susername,@Field("spassword") String spassword,@Field("course_name") String course_name,@Field("sphone") String sphone,@Field("semail") String semail,@Field("sem") String sem);



    @GET("teacher_names.php")
    Call<List<TeacherNameList>> getAllTeachersList();

    @GET("course_names.php")
    Call<List<CourseNamesList>> getAllcoursesList();

    @POST("fetch_teacher_name.php")
    @FormUrlEncoded
    Call<List<GetTeacherNameBean>> senddataforgettingteachername(@Field("semester") String semester, @Field("course_name") String course_name);

    @POST("fetch_student_name.php")
    @FormUrlEncoded
    Call<List<GetStudentNameBean>> senddataforgettingstudentname(@Field("semester") String semester, @Field("course_name") String course_name);

    @POST("pageforselectedcourses.php")
    @FormUrlEncoded
    Call<List<NameForGetSpinnerBean>> sendnameforcoursespinner(@Field("name") String teacher_name);

    @POST("pageforselectedsemester.php")
    @FormUrlEncoded
    Call<List<NameForGetSpinnerSemesterBean>> sendnameforsemesterspinner(@Field("name") String teacher_name);

    @POST("insertrecordsinStudentAttendance.php")
    @FormUrlEncoded
    Call<ResultOfAttendanceBean> savepostforprintingattendance(@Field("fromdate") String fromdate, @Field("todate") String todate, @Field("s_name") String s_name);


    @POST("insertattendanceinstudent_attendance.php")
    @FormUrlEncoded
    Call<String> saveStudentStatus(@Field("sname") ArrayList<String> stuname, @Field("status") ArrayList<String> status,
                                   @Field("tname") String teach_name,@Field("sem") String sem,@Field("branch") String branch);
    @POST("fetch_teacher_name_for_feedback.php")
    @FormUrlEncoded
    Call<List<GetTeacherNameForFeedbackBean>> sendsnameforfetchingteachersforfeedback(@Field("sname") String sname);

    @POST("insertattendanceinstudent_attendance.php")
    @FormUrlEncoded
    Call<String> saveTeacherFeedback(@Field("feedback") ArrayList<FeedbackBean> feedbean);

    @POST("insertFeedback.php")
    @FormUrlEncoded
    Call<ClassBean> savefeedback(@Field("t_name") String teachername, @Field("ratings") String ratings,@Field("comment") String comment);

    @POST("fetch_all_teacher_name_for_feedback.php")
    @FormUrlEncoded
    Call<List<GetAllTeacherNameForViewFeedback>> fetchingallteachersforfeedback(@Field("value") String value);

    @POST("insertDetailForPrintingStar.php")
    @FormUrlEncoded
    Call<ClassBean> sendDetailForViewStar(@Field("t_name") String teachername, @Field("fromdate") String fromdate,@Field("todate") String todate);



    //Call<TeacherBean> saveteacherdetails(@Field("tname") TBean teacher);

   /* @POST("student_get_all_data.php")
    @FormUrlEncoded
    Call<List<StudentBean>> getAllData();

    @POST("student_data.php")
    @FormUrlEncoded
    Call<StudentBean> getAlllData(@Field("rollno") String rollno);*/
}
