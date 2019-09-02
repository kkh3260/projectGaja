package com.tje.service;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.tje.domain.CateVO;

public class XMLParserIS {

	// �븘�뱶

	// 移댄뀒怨좊━
	String head = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/";
	String command;
	String serviceKey = "?ServiceKey=mV8Uk2CFnvvNLStullkHtkNJw3JQ9x8ZBEArK0ninQzgLsZNelK0CnKZ6mHcZTLF%2BdrXIH01E7iZ1xbYcrmA8w%3D%3D";
	String ContentTypeId = "&contentTypeId=";
	String AreaCode = "&areaCode=";
	String sigunguCode = "&sigunguCode=";
	String cat1;
	String cat2;
	String cat3;
	String listYN = "&listYN=Y";
	String mobileOS = "&MobileOS=ETC";
	String mobileApp = "&MobileApp=TourAPI3.0_Guide";
	String arrange = "&arrange=A";
	String numOfRows = "&numOfRows=";
	String pageNo = "&pageNo=";
//	String json = "&_type=json";
	String mainURL;
	String type;
	String totalCount;

	// �뵒�뀒�씪 泥ロ럹�씠吏�
	String ContentId = "&contentId=";
	String defaultYN = "&defaultYN=Y";
	String firstImageYN = "&firstImageYN=Y";
	String areacodeYN = "&areacodeYN=Y";
	String catcodeYN = "&catcodeYN=Y";
	String addrinfoYN = "&addrinfoYN=Y";
	String mapinfoYN = "&mapinfoYN=Y";
	String overviewYN = "&overviewYN=Y";
	String transGuideYN = "&transGuideYN=Y";

	// �씠誘몄�
	String Image = "&imageYN=N";

	private static String getTagValue(String tag, Element eElement) {
		try {
			NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
			Node nValue = (Node) nlList.item(0);
			return nValue.getNodeValue();
		} catch (NullPointerException e) {
			return "";
		}
	}

	// 移댄뀒怨좊━ URL
	public String setCateURL(String contentTypeId, String areaCode, String pageNo, String numOfRows,
			String totalCount) {
		command = "areaBasedList";
		

		System.out.println("xmlParser : setCateURL " + contentTypeId + ", " + areaCode + ", " + pageNo);

		if (contentTypeId.equals("12")) {
			// �옖�뱶留덊겕 (嫄댁텞臾� 議고삎臾�)
			cat1 = "&cat1=A02";
			cat2 = "&&cat2=";
			cat3 = "&&cat3=";
			this.mainURL = head + command + serviceKey + ContentTypeId + contentTypeId + AreaCode + areaCode
					+ sigunguCode + cat1 + cat2 + cat3 + listYN + mobileOS + mobileApp + arrange + numOfRows + pageNo;
					//+ pageno;
		}

		// �뿬�뻾肄붿뒪(媛�議깆퐫�뒪)
		else if (contentTypeId.equals("25")) {
			cat1 = "&cat1=C01";
			cat2 = "&&cat2=C0112";
			cat3 = "&&cat3=";
			this.mainURL = head + command + serviceKey + ContentTypeId + contentTypeId + AreaCode + areaCode
					+ sigunguCode + cat1 + cat2 + cat3 + listYN + mobileOS + mobileApp + arrange + numOfRows + pageNo;//+ pageno;
		}
		// �닕諛� (愿�愿묓샇�뀛)
		else if (contentTypeId.equals("32")) {
			cat1 = "&cat1=B02";
			cat2 = "&&cat2=B0201";
			cat3 = "&&cat3=";
			this.mainURL = head + command + serviceKey + ContentTypeId + contentTypeId + AreaCode + areaCode
					+ sigunguCode + cat1 + cat2 + cat3 + listYN + mobileOS + mobileApp + arrange + numOfRows + pageNo;//+ pageno;
			
		}

		// �눥�븨 ( �긽�꽕�떆�옣)
		else if (contentTypeId.equals("38")) {
			cat1 = "&cat1=A04";
			cat2 = "&&cat2=A0401";
			cat3 = "&&cat3=";
			this.mainURL = head + command + serviceKey + ContentTypeId + contentTypeId + AreaCode + areaCode
					+ sigunguCode + cat1 + cat2 + cat3 + listYN + mobileOS + mobileApp + arrange + numOfRows + pageNo;
					//+ pageno
		}
		// �쓬�떇(�븳�떇)
		else if (contentTypeId.equals("39")) {
			cat1 = "&cat1=A05";
			cat2 = "&&cat2=A0502";
			cat3 = "&&cat3=";
			this.mainURL = head + command + serviceKey + ContentTypeId + contentTypeId + AreaCode + areaCode
					+ sigunguCode + cat1 + cat2 + cat3 + listYN + mobileOS + mobileApp + arrange + numOfRows + pageNo;
					//+ pageno;
		}
		return mainURL;
	}

	// �뵒�뀒�씪 URL
	public String setDetailURL(String contentTypeId, String ContentId) {
		command = "detailCommon";
		System.out.println("xml Parser : setDetailURL " + contentTypeId + ", " + ContentId);
		this.mainURL = head + command + serviceKey + this.ContentTypeId + contentTypeId + this.ContentId + ContentId
				+ mobileOS + mobileApp + defaultYN + firstImageYN + areacodeYN + catcodeYN + addrinfoYN + mapinfoYN
				+ overviewYN + transGuideYN;

		return mainURL;
	}

	// �씠誘몄� URL
	public String setImageURL(String contentTypeId, String ContentId) {
		command = "detailImage";
		System.out.println("xml Parser : setImageURL " + contentTypeId + ", " + ContentId);
		this.mainURL = head + command + serviceKey + this.ContentTypeId + contentTypeId + mobileOS + mobileApp
				+ this.ContentId + ContentId + Image;

		return mainURL;
	}

	// �긽�꽭 �젙蹂� URL
	public String setIntroURL(String contentTypeId, String ContentId) {
		command = "detailIntro";
		type = contentTypeId;
		System.out.println("xml Parser : setIntroURL " + contentTypeId + ", " + ContentId);

		this.mainURL = head + command + serviceKey + this.ContentTypeId + contentTypeId + this.ContentId + ContentId
				+ mobileOS + mobileApp;
		return mainURL;

	}

	public List<Object> parserXML(String mainURL) {

		List<Object> list = new ArrayList<Object>();

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(mainURL);

			// root tag
			doc.getDocumentElement().normalize();
			System.out.println("Root element:" + doc.getDocumentElement().getNodeName());

			// �뙆�떛�븷 tag
			NodeList nList = doc.getElementsByTagName("item");
			System.out.println("�뙆�떛�븷 由ъ뒪�듃�닔 :" + nList.getLength());

			// 吏��뿭湲곕컲 移댄뀒怨좊━ URL �뙆�떛
			if (this.command.equals("areaBasedList")) {
				for (int i = 0; i < nList.getLength(); i++) {
					Node nNode = nList.item(i);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
						Element eElement = (Element) nNode;
						CateVO cateVO = new CateVO();
						
						
						cateVO.setAddr1(getTagValue("addr1", eElement));
						cateVO.setAreacode(getTagValue("areacode", eElement));
						cateVO.setContentid(getTagValue("contentid", eElement));
						cateVO.setContenttypeid(getTagValue("contenttypeid", eElement));
						cateVO.setFirstimage(getTagValue("firstimage", eElement));
						cateVO.setSigungucode(getTagValue("sigungucode", eElement));
						cateVO.setTel(getTagValue("tel", eElement));
						cateVO.setTitle(getTagValue("title", eElement));
						cateVO.setPageNo(getTagValue("pageNo", eElement));
						cateVO.setNumOfRows(getTagValue("numOfRows", eElement));
						cateVO.setTotalCount(getTagValue("totalCount", eElement));
						
						
						
						
						
						
						
						
//						cateVO.setPageNo(getTagValue("pageNo", eElement));
						list.add(cateVO);

						// System.out.println("cateVO : " + list);
					}
				}
			}
//			// �뵒�뀒�씪 URL �뙆�떛
//			else if (this.command.equals("detailCommon")) {
//				for (int i = 0; i < nList.getLength(); i++) {
//					Node nNode = nList.item(i);
//
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//						DetailCommonVO detailCommonVO = new DetailCommonVO();
//
//						detailCommonVO.setContentid(getTagValue("contentid", eElement));
//						detailCommonVO.setContenttypeid(getTagValue("contenttypeid", eElement));
//						detailCommonVO.setAddr1(getTagValue("addr1", eElement));
//						detailCommonVO.setAddr2(getTagValue("addr2", eElement));
//						detailCommonVO.setFirstimage(getTagValue("firstimage", eElement));
//						detailCommonVO.setFirstimage2(getTagValue("firstimage2", eElement));
//						detailCommonVO.setMapx(getTagValue("mapx", eElement));
//						detailCommonVO.setMapy(getTagValue("mapy", eElement));
//						detailCommonVO.setOverview(getTagValue("overview", eElement));
//						detailCommonVO.setHomepage(getTagValue("homepage", eElement));
//						detailCommonVO.setTitle(getTagValue("title", eElement));
//						list.add(detailCommonVO);
//
//						System.out.println("detailCommonVO : " + list);
//					}
//				}
//			}
//			// �씠誘몄� URL �뙆�떛
//			else if (this.command.equals("detailImage")) {
//				for (int i = 0; i < nList.getLength(); i++) {
//					Node nNode = nList.item(i);
//
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//						ImageVO imageVO = new ImageVO();
//
//						imageVO.setContentid(getTagValue("contentid", eElement));
//						imageVO.setOriginimgurl(getTagValue("originimgurl", eElement));
//						list.add(imageVO);
//
//						System.out.println("imageVO : " + list);
//					}
//				}
//			}
//			// �옖�뱶留덊겕 �긽�꽭�젙蹂� URL �뙆�떛
//			else if (this.type.equals("12") && this.command.equals("detailIntro")) {
//				System.out.println("detailIntro type :12 �뙆�떛�떆�옉 " + this.type.equals("12"));
//				for (int i = 0; i < nList.getLength(); i++) {
//					Node nNode = nList.item(i);
//
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//						Detail_Intro_landmarkVO landmarkVO = new Detail_Intro_landmarkVO();
//						landmarkVO.setChkbabycarriage(getTagValue("chkbabycarriage", eElement));
//						landmarkVO.setChkcreditcard(getTagValue("chkcreditcard", eElement));
//						landmarkVO.setChkpet(getTagValue("chkpet", eElement));
//						landmarkVO.setInfocenter(getTagValue("infocenter", eElement));
//						landmarkVO.setRestdate(getTagValue("restdate", eElement));
//						landmarkVO.setParking(getTagValue("parking", eElement));
//						landmarkVO.setOpendate(getTagValue("opendate", eElement));
//						landmarkVO.setAccomcount(getTagValue("accomcount", eElement));
//
//						list.add(landmarkVO);
//
//						System.out.println("detailIntro type :12  : " + list);
//					}
//				}
//			}
//			// �눥�븨 ( �긽�꽕�떆�옣) �긽�꽭�젙蹂� URL �뙆�떛
//			else if (this.type.equals("38") && this.command.equals("detailIntro")) {
//				System.out.println("detailIntro type :38 �뙆�떛�떆�옉 " + this.type.equals("38"));
//				for (int i = 0; i < nList.getLength(); i++) {
//					Node nNode = nList.item(i);
//
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//						Detail_Intro_shoppingVO shoppingVO = new Detail_Intro_shoppingVO();
//						shoppingVO.setChkbabycarriageshopping(getTagValue("chkbabycarriageshopping", eElement));
//						shoppingVO.setChkcreditcardshopping(getTagValue("chkcreditcardshopping", eElement));
//						shoppingVO.setChkpetshopping(getTagValue("chkpetshopping", eElement));
//						shoppingVO.setInfocentershopping(getTagValue("infocentershopping", eElement));
//						shoppingVO.setOpendateshopping(getTagValue("opendateshopping", eElement));
//						shoppingVO.setRestdateshopping(getTagValue("restdateshopping", eElement));
//						shoppingVO.setParkingshopping(getTagValue("parkingshopping", eElement));
//						shoppingVO.setSaleitem(getTagValue("saleitem", eElement));
//						shoppingVO.setSaleitemcost(getTagValue("saleitemcost", eElement));
//						shoppingVO.setScaleshopping(getTagValue("scaleshopping", eElement));
//
//						list.add(shoppingVO);
//
//						System.out.println("detailIntro type :38  : " + list);
//					}
//				}
//			} // �쓬�떇�젏 �긽�꽭�젙蹂� URL �뙆�떛
//			else if (this.type.equals("39") && this.command.equals("detailIntro")) {
//				System.out.println("detailIntro type :39 �뙆�떛�떆�옉 " + this.type.equals("39"));
//				for (int i = 0; i < nList.getLength(); i++) {
//					Node nNode = nList.item(i);
//
//					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//						Element eElement = (Element) nNode;
//						Detaill_Intro_restaurantsVO restaurantsVO = new Detaill_Intro_restaurantsVO();
//						restaurantsVO.setDiscountinfofood(getTagValue("chkcreditcardfood", eElement));
//						restaurantsVO.setDiscountinfofood(getTagValue("discountinfofood", eElement));
//						restaurantsVO.setFirstmenu(getTagValue("firstmenu", eElement));
//						restaurantsVO.setInfocenterfood(getTagValue("infocenterfood", eElement));
//						restaurantsVO.setKidsfacility(getTagValue("kidsfacility", eElement));
//						restaurantsVO.setOpentimefood(getTagValue("opentimefood", eElement));
//						restaurantsVO.setPacking(getTagValue("packing", eElement));
//						restaurantsVO.setParkingfood(getTagValue("parkingfood", eElement));
//						restaurantsVO.setReservationfood(getTagValue("reservationfood", eElement));
//						restaurantsVO.setRestdatefood(getTagValue("restdatefood", eElement));
//						restaurantsVO.setSmoking(getTagValue("smoking", eElement));
//						restaurantsVO.setTreatmenu(getTagValue("treatmenu", eElement));
//
//						list.add(restaurantsVO);
//
//						System.out.print	ln("detailIntro type :39  : " + list);
//					}
//				}
//			}

		} catch (Exception e) {

			System.out.println("cateService �뿉�윭");
			e.printStackTrace();
		}

		return list;
	}
}
