package Day;

import java.io.*;

public class FileCopyUtil {
    //源文件作为输入流，目标文件作为输出流

//      复制拷贝方法
    public static void copyFile(String sourcePath,String destPath){

        checkArgs(sourcePath,"原路径不能为空并且必须是个文件夹");
        checkArgs(destPath,"目标路径不能为空");

        File inFile=new File(sourcePath);
        checkFile(inFile,"源文件必须是个文件而且不能为空");
        File outFile=new File(destPath);
        checkParentFile(outFile,"目标文件不能为空");
        dataCopy(inFile,outFile);
    }
    //真正的数据拷贝
    private static void dataCopy(File source,File dest) {

        try(InputStream in=new FileInputStream(source);
            OutputStream out=new FileOutputStream(dest)
        ) {
            long start=System.currentTimeMillis();
            //1.read() 一个字节一个字节地读，效率太低
            //2.do...while 至少执行一次
            //3.byte[]  while
            byte[] buff=new byte[1024*1024];
            //len表示依次循环从输入流中读取的数据字节数
            int len=-1;
            while((len=in.read(buff))!=-1){
                out.write(buff,0,len);
            }
            long end=System.currentTimeMillis();
            System.out.println("真正拷贝耗时"+(end-start)+"ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    检查参数方法：参数为空 就抛出异常
//    args：参数信息；msg:异常提示信息
//    String实现了Charsequence
    private static void checkArgs(Object args,String msg){
        if(args==null){
            throw new IllegalArgumentException(msg);
        }
        if(args instanceof CharSequence){
            if(((CharSequence)args).length()==0){
                throw new IllegalArgumentException(msg);
            }
        }

    }
    private static void checkFile(File file,String msg){
        if(file==null||!file.exists()||file.isDirectory()){
            throw new IllegalArgumentException(msg);
        }
    }
    private static void checkParentFile(File file,String msg){
        //判断文件是否为空；如果parentFile不存在就创建，mkdirs（）；
        // 创建返回值，成功就返回true，失败就抛出异常
        if(file==null||file.isDirectory()){
            throw new IllegalArgumentException(msg);
        }
        File parentFile=file.getParentFile();

        if(!parentFile.exists()) {
            boolean rs = parentFile.mkdirs();
            if (!rs) {
                throw new RuntimeException("创建的文件" + file.getAbsolutePath() + "父目录已经存在");
            }
        }
    }
    public static void main(String[] args) {
        copyFile("F:"+File.separator+"笔记"+File.separator+"22.txt",
                "F:"+File.separator+"test01.txt");

    }
}

