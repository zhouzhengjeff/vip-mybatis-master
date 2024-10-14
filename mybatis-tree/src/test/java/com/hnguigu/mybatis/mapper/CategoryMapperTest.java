package com.hnguigu.mybatis.mapper;

import com.hnguigu.mybatis.entity.Category;
import com.hnguigu.mybatis.entity.Category1;
import com.hnguigu.mybatis.utils.MyBatisUtils;
import com.hnguigu.mybatis.vo.CategoryVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapperTest {


    @Test
    public void testSave() {
        SqlSession sqlSession = null;
        Category parentCategory = null;

        try {

            sqlSession = MyBatisUtils.getSqlSession();
            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

            parentCategory = categoryMapper.findById(2);

            Category category = new Category();
            category.setName("Thinkpad X Serial");
            category.setParent(parentCategory);

            categoryMapper.save(category);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFindByName() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

            Category category = categoryMapper.findByName("Thinkpad");
            System.out.println(category.getId() + "---" + category.getName());

            System.out.println();

            Category parentCategory = category.getParent();
            System.out.println(parentCategory.getId() + "---" + parentCategory.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFindByName1() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

            Category category = categoryMapper.findByName("Thinkpad");
            System.out.println(category.getId() + "---" + category.getName());

            System.out.println();

            Category parentCategory = category.getParent();
            System.out.println(parentCategory.getId() + "---" + parentCategory.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }


    @Test
    public void testGetByName() {
        SqlSession sqlSession = null;

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

            // TODO 1. 根据类别名称查询类别，此时就会查询parent_id字段值
            //  select category_id,category_name parent_id from mybatis_categtory
            //  where
            //  category_name = ?

            Category1 category1 = categoryMapper.getByName("Thinkpad");

            Integer parentId = category1.getParentId();
            Category parentCategory = categoryMapper.findById(parentId);

            System.out.println(category1);
            System.out.println(parentCategory);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testSearchChildrenByName() {
        SqlSession sqlSession = null;
        List<CategoryVO> categoryVOList = new ArrayList<>();

        try {
            sqlSession = MyBatisUtils.getSqlSession();
            CategoryMapper categoryMapper = sqlSession.getMapper(CategoryMapper.class);

            Category1 slefCategory1 = categoryMapper.getByName("Thinkpad");

            List<Category1> childCategoryList = categoryMapper.searchChildrenByName("Thinkpad");
            childCategoryList.stream().forEach(System.out::println);

            // 作业 TODO 子类别的数据以及自身数据加工成CategoryVO
            categoryVOList = childCategoryList.stream().map((category1) -> {
                CategoryVO categoryVO = new CategoryVO();
                categoryVO.setCategory(slefCategory1);
                categoryVO.setChildren(childCategoryList);
                return categoryVO;
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtils.closeSqlSession(sqlSession);
        }
    }
}