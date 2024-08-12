package com.Stock.StockApplication.service;

import org.springframework.stereotype.Service;
import com.Stock.StockApplication.entity.StockInfo;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockService {
    public StockInfo getStockInfo(String symbol){
         String apiKey = "FXZMKOABQE663P8Y";
         String interval = "1min";
        try {
            String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="
                    + symbol + "&interval=" + interval + "&apikey=" + apiKey;

            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                StringBuffer content;
                try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String inputLine;
                    content = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                }

                JSONObject jsonResponse = new JSONObject(content.toString());
                JSONObject timeSeries = jsonResponse.getJSONObject("Time Series (1min)");
                JSONObject metaData = jsonResponse.getJSONObject("Meta Data");

                String latestTime = metaData.getString("3. Last Refreshed");
                JSONObject latestData = timeSeries.getJSONObject(latestTime);

                DecimalFormat df = new DecimalFormat("#.######");
                double openingPrice = Double.parseDouble(latestData.getString("1. open"));
                double closingPrice = Double.parseDouble(latestData.getString("4. close"));
                double change = closingPrice - openingPrice;
                double percentChange = (change / openingPrice) * 100;
                double volume = Double.parseDouble(latestData.getString("5. volume"));
                // Prepare response as a String
                StockInfo stockInfo = new StockInfo(symbol,openingPrice,closingPrice,latestTime,change,percentChange,volume);
                return stockInfo;
            } else {
                return null;
            }
        } catch (IOException | JSONException e) {
            return null;
        }
    }
    public List<StockInfo> getStocksInfo(String symbols){
        String[] separatedSymbols= symbols.split(",");
        ArrayList<StockInfo> stockList= new ArrayList<>();

        for(String i: separatedSymbols){
           stockList.add(getStockInfo(i.trim()));
        }
        return stockList;
    }

}
