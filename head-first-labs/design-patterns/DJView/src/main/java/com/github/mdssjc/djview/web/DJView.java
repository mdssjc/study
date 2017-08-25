package com.github.mdssjc.djview.web;

import com.github.mdssjc.djview.BeatModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/djview")
public class DJView extends HttpServlet {

  @Override
  public void init() throws ServletException {
    final BeatModel beatModel = new BeatModel();
    beatModel.initialize();
    getServletContext().setAttribute("beatModel", beatModel);
  }

  @Override
  protected void doPost(final HttpServletRequest request,
                       final HttpServletResponse response)
      throws ServletException, IOException {
    final BeatModel beatModel = (BeatModel) getServletContext().getAttribute(
        "beatModel");

    String bpm = request.getParameter("bpm");
    if (bpm == null) {
      bpm = beatModel.getBPM() + "";
    }

    final String set = request.getParameter("set");
    if (set != null) {
      beatModel.setBPM(Integer.parseInt(bpm));
    }

    final String decrease = request.getParameter("decrease");
    if (decrease != null) {
      beatModel.setBPM(beatModel.getBPM() - 1);
    }

    final String increase = request.getParameter("increase");
    if (increase != null) {
      beatModel.setBPM(beatModel.getBPM() + 1);
    }

    final String on = request.getParameter("on");
    if (on != null) {
      beatModel.on();
    }

    final String off = request.getParameter("off");
    if (off != null) {
      beatModel.off();
    }

    request.setAttribute("beatModel", beatModel);

    request.getRequestDispatcher("jsp/DJView.jsp")
           .forward(request, response);
  }
}
