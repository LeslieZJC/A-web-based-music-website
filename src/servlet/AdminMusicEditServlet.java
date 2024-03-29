package servlet;

import model.Song;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.SongService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@WebServlet(name = "AdminMusicEditServlet", urlPatterns = "/admin/music_edit")
public class AdminMusicEditServlet extends HttpServlet {
  private SongService gService = new SongService();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    DiskFileItemFactory factory=new DiskFileItemFactory();//实现文件上传功能
    ServletFileUpload upload = new ServletFileUpload(factory);
    try {
      List<FileItem> list = upload.parseRequest(request);
      Song g = new Song();
      for(FileItem item:list) {
        if(item.isFormField()) {
          switch(item.getFieldName()) {
            case "id":
              g.setSong_id(Integer.parseInt(item.getString("utf-8")));
              break;
            case "name":
              g.setSong_name(item.getString("utf-8"));
              break;
            case "info":
              g.setInfo(item.getString("utf-8"));
              break;
          }
        }else {
          if(item.getInputStream().available()<=0)continue;
          String fileName = item.getName();
          fileName = "/"+new Date().getTime()+fileName;
          String path = "C://Users/Boby/Desktop/JayMusic1/web/upload"+fileName;
          InputStream in = item.getInputStream();
          FileOutputStream out = new FileOutputStream(path);
          byte[] buffer = new byte[1024];
          int len=0;
          while( (len=in.read(buffer))>0 ) {
            out.write(buffer);
          }
          in.close();
          out.close();
          item.delete();
          switch(item.getFieldName()) {
            case "image":
              g.setImage_url("/upload"+fileName);
              break;
            case "music":
              g.setAudio_url("/upload"+fileName);
              break;
          }
        }
      }
      gService.update(g);
      request.getRequestDispatcher("/admin/music_list.jsp").forward(request, response);
    } catch (FileUploadException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
  }
}
