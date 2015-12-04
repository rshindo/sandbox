/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import static org.hamcrest.CoreMatchers.is;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ryo_shindo
 */
public class MyResourceTest extends JerseyTest {
    
    public MyResourceTest() {
    }
    
    public static class TestBinder extends AbstractBinder {

        @Override
        protected void configure() {
            bind(HogeServiceImpl.class).to(HogeService.class);
            bind(SessionServiceImpl.class).to(SessionService.class);
        }
        
    }

    @Override
    protected Application configure() {
        return new ResourceConfig().register(new TestBinder()).register(MyResource.class);
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Test of getIt method, of class MyResource.
     */
    @Test
    public void testGetIt() {
        System.out.println("getIt");
        String expected = "Got it!";
        String actual = target("myresource").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void testGetHoge() {
        System.out.println("hogehoge");
        String expected = "hogehoge!";
        String actual = target("myresource")
                .path("hoge")
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void testGetCount() {
        System.out.println("testGetCount");
        String expected = "count: 0";
        String actual = target("myresource")
                .path("count")
                .request()
                .accept(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(actual, is(expected));
    }

    /**
     * Test of post method, of class MyResource.
     */
    @Test
    public void testPost() {
        System.out.println("post");
        String value = "aaa";
        Form form = new Form();
        form.param("value", value);
        String result = target("myresource").path("post").request().accept(MediaType.TEXT_PLAIN).post(Entity.form(form), String.class);
        assertThat(result, is(value));
    }
    
    @Test
    public void testDisplayUserInfo() {
        System.out.println("user");
        String userId = "user001";
        String name = "shindo";
        Integer age = 25;
        Form form = new Form();
        form.param("userId", userId);
        form.param("name", name);
        form.param("age", age.toString());
        String expected = userId+":"+name+":"+age;
        String actual = target("myresource").path("user").request().accept(MediaType.TEXT_PLAIN).post(Entity.form(form), String.class);
        assertThat(actual, is(expected));
    }
    
    @Test
    public void ユーザIDを入力しない() {
        String userId = "";
        String name = "shindo";
        Integer age = 25;
        Form form = new Form();
        form.param("userId", userId);
        form.param("name", name);
        form.param("age", age.toString());
        String expected = userId+":"+name+":"+age;
        Response response = target("myresource").path("user").request().accept(MediaType.TEXT_PLAIN).post(Entity.form(form), Response.class);
        assertThat(response.getStatus(), is(HttpStatus.BAD_REQUEST_400.getStatusCode()));
    }
    
}
