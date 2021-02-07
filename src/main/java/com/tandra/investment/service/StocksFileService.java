package com.tandra.investment.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@Service
public class StocksFileService {


    public Set<String> readStockListFromFile() {
        Set<String > stockList = new HashSet<>();
        String line;
        try {
            BufferedReader input =  new BufferedReader(new FileReader("stocklist.txt"));
            if(!input.ready()){
                throw new IOException();
            }
            while((line = input.readLine()) != null ){
                stockList.add(line);
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stockList;
    }
    public void addStockToFile(String stockSticker) throws IOException {
        BufferedWriter bw = null;
            bw = new BufferedWriter( new FileWriter("stocklist.txt",true) );
            bw.write(stockSticker);
            bw.flush();
            bw.newLine();
            bw.close();

    }
    public void deleteStockByStickerID(String stickerId) throws IOException {
        String  record;
        File tempDB = new File("stocklist.txt_temp.txt");
        File db = new File("stocklist.txt");
        BufferedReader br = new BufferedReader( new FileReader( db ) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );
        while( ( record = br.readLine() ) != null ) {
           if( record.contains(stickerId) )
              continue;
            bw.write(record);
            bw.flush();
            bw.newLine();
        }
        br.close();
        bw.close();
        db.delete();
        tempDB.renameTo(db);

    }

    /*public void writeStockListIntoFile(Set<String> stockList){
        try {
            FileWriter fileWriter = new FileWriter("stocklist.txt");
            Writer output =  new BufferedWriter(fileWriter);
            for (String s : stockList) {
                output.write(s +"\n");
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/



}
