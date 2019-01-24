package com.demo.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.demo.entity.NewsTable;

@Mapper
public interface NewsTableMapper {

public List<NewsTable> selectall(Map map);

public List<NewsTable> nstatusselectall(Map map);

public int count();

public NewsTable selectbyid(int id);

public int addnews(NewsTable newsTable);

public int deletenews(int id);

public int updatenews(NewsTable newsTable);

public int shenhenews(Map map);

}
