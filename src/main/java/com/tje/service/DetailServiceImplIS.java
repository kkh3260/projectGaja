package com.tje.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.tje.domain.DetailVO;

@Service
public class DetailServiceImplIS implements DetailServiceIS {

	@Override
	public List<DetailVO> getDetailList(String contentTypeId, String contentId) {
		String basicUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon";
		String serviceKey = "?ServiceKey=mV8Uk2CFnvvNLStullkHtkNJw3JQ9x8ZBEArK0ninQzgLs"
				+ "ZNelK0CnKZ6mHcZTLF%2BdrXIH01E7iZ1xbYcrmA8w%3D%3D&";
		String contenttypeId = "contentTypeId=" + contentTypeId + "&";
		String contentid = "contentId=" + contentId + "&";
		String must = "MobileOS=ETC&MobileApp=TourAPI3.0_Guide&";
		String numofrows = "numOfRows=10&";
		String otherInfo = "defaultYN=Y&firstImageYN=Y&areacodeYN=Y&"
				+ "catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y&transGuideYN=Y";
		String parseType = "&_type=json";

		// 1. 요청 정보를 입력한다.
		String mainUrl = basicUrl + serviceKey + contenttypeId + contentid + must + otherInfo + numofrows + parseType;

		List<DetailVO> detailList = new ArrayList<DetailVO>();
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		String line = " ";

		try {
			// url 객체를 만든다.
			URL url = new URL(mainUrl);
			// 정보를 받아온다.
			br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			// 버퍼에 있는 정보를 하나의 문자열로 변환
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String jsonInput = sb.toString();

			// 5. Json Parser를 만들어 만들어진 문자열 데이터를 객체화.
			JsonParser parser = new JsonParser();
			JsonObject obj = (JsonObject) parser.parse(jsonInput);

			// Top레벨 단계인 response 키를 가지고 데이터를 파싱한다.
			JsonObject parseResponse = (JsonObject) obj.get("response");

			// response 객체로 부터 body를 찾아온다.
			JsonObject parseBody = (JsonObject) parseResponse.get("body");

			// body로 부터 items를 받아온다.
			JsonObject parseItems = (JsonObject) parseBody.get("items");
			JsonObject parseItem = (JsonObject) parseItems.get("item");
			
			JsonArray detailArray = new JsonArray();
			
			detailArray.add(parseItem);
			

			int i;

			for (i = 0; i < detailArray.size(); i++) {
				// HomeVO는 반드시 for문 안에 선언해야, 데이터를 꺼내올때마다 새로운 데이터를 저장한다.
				// 그렇지 않으면 마지막에 가져온 데이터만 출력된다.
				JsonObject detailInfo = (JsonObject) detailArray.get(i);
				DetailVO detailvo = new DetailVO();

				// 참고 사이트 : https://kkgram.tistory.com/9
				try {
						detailvo.setContentid(detailInfo.get("contentid").getAsInt());
						detailvo.setContenttypeid(detailInfo.get("contenttypeid").getAsInt());
						detailvo.setAddr1(detailInfo.get("addr1").getAsString());
						detailvo.setAreacode(detailInfo.get("areacode").getAsInt());
						detailvo.setTel(detailInfo.get("tel").getAsString());
						detailvo.setTitle(detailInfo.get("title").getAsString());
						detailvo.setFirstimage(detailInfo.get("firstimage").getAsString());
						detailvo.setHomepage(detailInfo.get("homepage").getAsString());
						detailvo.setOverview(detailInfo.get("overview").getAsString());
						detailvo.setZipcode(detailInfo.get("zipcode").getAsString());
						detailvo.setFirstimage2(detailInfo.get("firstimage2").getAsString());
						detailvo.setMapx(detailInfo.get("mapx").getAsString());
						detailvo.setMapy(detailInfo.get("mapy").getAsString());
				} catch (Exception e) {
					System.out.println("Null 값인 항목은" + detailInfo + "입니다");
				}
				detailList.add(detailvo);
			}
			br.close();
		} catch (MalformedURLException e) {
			System.out.println("=====URLException이 발생했습니다~=====");
		} catch (UnsupportedEncodingException e) {
			System.out.println("=====UnsupportedEncodingException이 발생했습니다~=====");
		} catch (IOException e) {
			System.out.println("=====IOException이 발생했습니다~=====");
		}
		return detailList;
	}

}
