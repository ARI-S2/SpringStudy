package com.sist.dao;
// => MapperFactoryBean
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public interface StudentMapper {
	@Select("select * from student")
	public List<StudentVO> studentListData();
	
	@Select("select * from student where hakbun=#{hakbun}")
	public StudentVO studentDetailData(int hakbun);
	
	@Insert("insert into student values(std_hak_seq.nextval,#{name},#{kor},#{eng},#{math})")
	public void studentInsert(StudentVO vo);
	
	@Delete("delete from student where hakbun=#{hakbun}")
	public void studentDelete(int hakbun);
	
	@Update("update student set name=#{name},kor=#{kor},eng=#{eng},math=#{math} where hakbun=#{hakbun}")
	public void studentUpdate(StudentVO vo);
}
