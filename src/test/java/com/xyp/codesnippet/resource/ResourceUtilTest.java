package com.xyp.codesnippet.resource;

import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter Xu
 */
public class ResourceUtilTest {
    
    public ResourceUtilTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadClasspathResource method, of class ResourceUtil.
     */
    @Test
    public void testLoadClasspathResource() {
        System.out.println("loadClasspathResource");
        String file = "com/xyp/codesnippet/xml/book.xml";
        InputStream result = ResourceUtil.loadClasspathResource(file);
        assertNotNull(result);
    }

    /**
     * Test of getClassLoader method, of class ResourceUtil.
     */
    @Test
    public void testGetClassLoader() {
        System.out.println("getClassLoader");
        ClassLoader result = ResourceUtil.getClassLoader();
        assertNotNull(result);
    }
}