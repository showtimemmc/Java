package me.ishowtime.helper;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FileHelperTest {

    @Test
    public void testGetExtentionName_RelativePath() throws Exception {
        String pathName = "FileHelper/FileHelper.iml";
        assertEquals("iml",FileHelper.getExtentionName(pathName));
        assertEquals("iml",FileHelper.getExtentionName(new File(pathName)));
    }
    @Test
    public void testGetExtentionName_AbsolutePath() throws Exception {
        String pathName = "/Users/ishowtime/Documents/src/Java/Helper/FileHelper/FileHelper.iml";
        assertEquals("iml",FileHelper.getExtentionName(pathName));
        assertEquals("iml",FileHelper.getExtentionName(new File(pathName)));
    }
 /*   @Test
    public void testGetExtentionName_FileNotExist() throws Exception {
        String pathName = "src/this_file_is_not_exist";
        assertNull(FileHelper.getExtentionName(pathName));
        assertNull(FileHelper.getExtentionName(new File(pathName)));
    }*/


}