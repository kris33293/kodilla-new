package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    TaskListDao taskListDao;
    private static final String LIST_NAME = "ToDo";

    @Test
    void testFindByListName(){

        //Given
        TaskList taskList = new TaskList("DESCRIPTION","ToDo");
        taskListDao.save(taskList);

        //When
        List<TaskList> readTaskLists = taskListDao.findByListName(LIST_NAME);

        //Then
        assertEquals(1,readTaskLists.size());

        //CleanUp
        taskListDao.delete(taskList);
    }


}
