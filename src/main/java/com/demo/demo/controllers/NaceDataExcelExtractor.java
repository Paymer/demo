package com.demo.demo.controllers;

import com.demo.demo.entities.NaceEntity;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NaceDataExcelExtractor implements INaceDataExtractor {

    @Override
    public List<NaceEntity> getNaceData(String fileName) {


        List<NaceEntity> naceEntityList = new ArrayList<>();

        FileReader fr = null;

        try {
            File csvFile = new File(fileName);
            fr = new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fr);

            boolean isHeadersLine = true;
            //We read each line until the end of the file
            String line;
            while ((line = br.readLine()) != null) {

                //We use the separator ;
                String[] data = line.split(";");

                /*while(data.length<10){
                    line = br.readLine();
                    if(line.contains("\"")){
                        line.s
                    }
                    String[] dataAuxiliary = line.split("\"");


                }*/

                if(!isHeadersLine) {
                    NaceEntity entity = fullfillEntity(data);
                    naceEntityList.add(entity);

//                    System.out.println(data);
//                    System.out.println(entity);
                }else{
                    //we skip the first line
                    isHeadersLine = false;
                }



            }

            //Exceptions
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return naceEntityList;
    }

    private NaceEntity fullfillEntity(String[] datos) {
        NaceEntity entity = new NaceEntity();
        entity.setOrder(Long.valueOf(datos[0]));
        entity.setLevel(Integer.valueOf(datos[1]));
        entity.setCode(datos[2]);
        entity.setParent(datos[3]);
        entity.setDescription(datos[4]);
        entity.setItemIncludes(datos[5]);
        entity.setAlsoIncludes(datos[6]);
        entity.setRulings(datos[7]);
        entity.setItemExcludes(datos[8]);
        entity.setReferenceIsic(datos[9]);


       return entity;
    }


}
