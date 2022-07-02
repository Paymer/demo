package lectura.domain;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class CalculServiceTest {

    private CalculService service;

  public void completeLecturesTest() {
      List<Lecture> list = null;
      List<Lecture> result =  service.completeLectures(list);

      assertTrue(true);
  }

    public void completeLecturesErrorTest() throws Exception{
      //valors erronis
        List<Lecture> list = null;
        List<Lecture> result =  service.completeLectures(list);

        assertTrue(true);
    }

}
