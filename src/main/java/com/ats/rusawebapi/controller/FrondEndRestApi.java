package com.ats.rusawebapi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ats.rusawebapi.common.LastUpdatedSiteDate;
import com.ats.rusawebapi.model.BannerImages;
import com.ats.rusawebapi.model.CalenderList;
import com.ats.rusawebapi.model.CategoryList;
import com.ats.rusawebapi.model.CategoryListWithContentCount;
import com.ats.rusawebapi.model.CmsSearchData;
import com.ats.rusawebapi.model.ContactUs;
import com.ats.rusawebapi.model.DocType;
import com.ats.rusawebapi.model.DocumentUpload;
import com.ats.rusawebapi.model.EventRecord;
import com.ats.rusawebapi.model.EventRegistration;
import com.ats.rusawebapi.model.GallaryDetail;
import com.ats.rusawebapi.model.HomeData;
import com.ats.rusawebapi.model.ImageLink;
import com.ats.rusawebapi.model.ImageListByCategory;
import com.ats.rusawebapi.model.InstituteInfo;
import com.ats.rusawebapi.model.Logo;
import com.ats.rusawebapi.model.Maintainance;
import com.ats.rusawebapi.model.MetaData;
import com.ats.rusawebapi.model.NewsDetails;
import com.ats.rusawebapi.model.NewsSectionList;
import com.ats.rusawebapi.model.Page;
import com.ats.rusawebapi.model.PageMetaData;
import com.ats.rusawebapi.model.ParameterModel;
import com.ats.rusawebapi.model.PreviousRegRecord;
import com.ats.rusawebapi.model.Registration;
import com.ats.rusawebapi.model.RegistrationUserDetail;
import com.ats.rusawebapi.model.Result;
import com.ats.rusawebapi.model.SectionTree;
import com.ats.rusawebapi.model.SmsCode;
import com.ats.rusawebapi.model.SocialChannels;
import com.ats.rusawebapi.model.SubCategoryList;
import com.ats.rusawebapi.model.TestImonial;
import com.ats.rusawebapi.model.TopMenuList;
import com.ats.rusawebapi.model.University;
import com.ats.rusawebapi.model.UploadDocument;
import com.ats.rusawebapi.model.frontend.CmsContent;
import com.ats.rusawebapi.model.frontend.FaqContent;
import com.ats.rusawebapi.model.frontend.PageContent;
import com.ats.rusawebapi.model.mst.GetCategory;
import com.ats.rusawebapi.model.mst.Info;
import com.ats.rusawebapi.repo.BannerImagesRepository;
import com.ats.rusawebapi.repo.CategoryListRepository;
import com.ats.rusawebapi.repo.CategoryListWithContentCountRepo;
import com.ats.rusawebapi.repo.CmsSearchDataRepository;
import com.ats.rusawebapi.repo.ContactUsRepo;
import com.ats.rusawebapi.repo.DocTypeRepo;
import com.ats.rusawebapi.repo.DocumentUploadRepository;
import com.ats.rusawebapi.repo.EventRecordRepo;
import com.ats.rusawebapi.repo.EventRegisterRepository;
import com.ats.rusawebapi.repo.GallaryDetailRepository;
import com.ats.rusawebapi.repo.ImageLinkRepository;
import com.ats.rusawebapi.repo.ImageListByCategoryRepo;
import com.ats.rusawebapi.repo.InstituteInfoRepo;
import com.ats.rusawebapi.repo.LogoRepository;
import com.ats.rusawebapi.repo.MetaDataRepository;
import com.ats.rusawebapi.repo.NewsDetailsRepository;
import com.ats.rusawebapi.repo.NewsSectionListRepo;
import com.ats.rusawebapi.repo.PageMetaDataRepository;
import com.ats.rusawebapi.repo.PageRepo;
import com.ats.rusawebapi.repo.PagesModuleRepository;
import com.ats.rusawebapi.repo.PreviousRegRecordRepo;
import com.ats.rusawebapi.repo.RegistrationRepo;
import com.ats.rusawebapi.repo.ResultRepository;
import com.ats.rusawebapi.repo.SectionTreeRepository;
import com.ats.rusawebapi.repo.SettingRepo;
import com.ats.rusawebapi.repo.SiteMaintenanceRepository;
import com.ats.rusawebapi.repo.SmsCodeRepository;
import com.ats.rusawebapi.repo.SocialChannelRepository;
import com.ats.rusawebapi.repo.SubCategoryListRepository;
import com.ats.rusawebapi.repo.TestImonialRepository;
import com.ats.rusawebapi.repo.UniversityRepo;
import com.ats.rusawebapi.repo.UploadDocumentRepo;
import com.ats.rusawebapi.repo.frontend.CmsContentRepository;
import com.ats.rusawebapi.repo.frontend.FaqContentRepository;
import com.ats.rusawebapi.repo.mst.GetCategoryRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FrondEndRestApi {

	@Autowired
	PageRepo pageRepo;

	@Autowired
	PagesModuleRepository pagesModuleRepo;

	@Autowired
	CmsContentRepository cmsContentRepository;

	@Autowired
	FaqContentRepository faqContentRepository;

	@Autowired
	DocumentUploadRepository documentUploadRepository;

	@Autowired
	TestImonialRepository testImonialListRepo;

	@Autowired
	GallaryDetailRepository gallaryDetailRepository;

	@Autowired
	NewsDetailsRepository newsBolgRepo;

	@Autowired
	SectionTreeRepository sectionTreeRepository;

	@Autowired
	CategoryListRepository categoryListRepository;

	@Autowired
	SubCategoryListRepository subCategoryListRepository;

	@Autowired
	SiteMaintenanceRepository siteMaintenanceRepo;

	@Autowired
	SettingRepo settingRepository;

	@Autowired
	MetaDataRepository metaDataRepo;

	@Autowired
	PageMetaDataRepository pageMetaDataRepo;

	@Autowired
	ResultRepository resultRepository;

	@Autowired
	ImageListByCategoryRepo imageListByCategoryRepo;

	@Autowired
	EventRecordRepo eventRecordRepo;

	@Autowired
	NewsSectionListRepo newsSectionListRepo;

	@Autowired
	PreviousRegRecordRepo previousRegRecordRepo;

	@Autowired
	SmsCodeRepository smsCodeRepo;

	@Autowired
	CategoryListWithContentCountRepo categoryListWithContentCountRepo;

	@Autowired
	InstituteInfoRepo instituteInfoRepo;

	@Autowired
	UniversityRepo universityRepo;

	@Autowired
	DocTypeRepo docTypeRepo;

	@Autowired
	UploadDocumentRepo uploadDocumentRepo;

	@Autowired
	RegistrationRepo registrationRepo;

	@Autowired
	NewsDetailsRepository newsDetailRepo;

	@Autowired
	BannerImagesRepository bannerImagesRepo;

	@Autowired
	CmsSearchDataRepository cmsPageDescRepository;

	@Autowired
	ImageLinkRepository imageLinkRepo;

	@Autowired
	EventRegisterRepository eventRegRepo;

	@Autowired
	ContactUsRepo contactUsRepo;

	@Autowired
	GetCategoryRepo getGetCategoryRepo;

	@Autowired
	SocialChannelRepository socialDetailRepo;

	@Autowired
	LogoRepository LogoRepo;

	@RequestMapping(value = { "/getTopMenuList" }, method = RequestMethod.POST)
	public @ResponseBody TopMenuList getTopMenuList(@RequestParam("langId") int langId,
			@RequestParam("type") List<Integer> type) {

		TopMenuList topMenuList = new TopMenuList();

		try {

			List<SectionTree> list = sectionTreeRepository.getSectionListByLangId(langId, type);
			topMenuList.setSectionlist(list);

			List<CategoryList> categoryList = categoryListRepository.getCategoryListByLangId(langId);
			topMenuList.setCategoryList(categoryList);

			List<SubCategoryList> subCategoryList = subCategoryListRepository.getSubCategoryListByLangId(langId);
			topMenuList.setSubCatList(subCategoryList);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return topMenuList;

	}

	@RequestMapping(value = { "/getDataBySlugName" }, method = RequestMethod.POST)
	public @ResponseBody PageContent getDataBySlugName(@RequestParam("slugName") String slugName,
			@RequestParam("langId") int langId) {

		PageContent pageContent = new PageContent();
		try {

			Page page = pageRepo.findByPageSlug(slugName, langId);
			List<Integer> moduleList = pagesModuleRepo.getmoduleList(page.getPageId());
			int sectionId = pageRepo.getSectioinId(page.getPageId());
			pageContent.setPageId(page.getPageId());
			pageContent.setPageName(page.getPageName());
			pageContent.setSectioinId(sectionId);
			for (int i = 0; i < moduleList.size(); i++) {

				if (moduleList.get(i) == 1) {

					List<CmsContent> cmsContentList = cmsContentRepository.getCmsContent(langId, page.getPageId());
					pageContent.setCmsContentList(cmsContentList);

				} else if (moduleList.get(i) == 2) {

					List<FaqContent> faqContentList = faqContentRepository.getFaqContent(langId, page.getPageId());
					pageContent.setFaqContentList(faqContentList);

				} else if (moduleList.get(i) == 7) {

					List<DocumentUpload> documentUploadList = documentUploadRepository
							.findByPageIdAndDelStatusAndIsActiveOrderBySortNo(page.getPageId(), 1, 1);
					pageContent.setDocumentUploadList(documentUploadList);
				} else if (moduleList.get(i) == 6) {

					List<TestImonial> testImonialList = testImonialListRepo
							.findByPageIdAndDelStatusAndIsActiveAndSectionIdOrderBySortNo(page.getPageId(), 1, 1, 6,
									langId);
					pageContent.setTestImonialList(testImonialList);
				} else if (moduleList.get(i) == 3) {

					List<GallaryDetail> gallaryDetailList = gallaryDetailRepository
							.findByIsActiveAndDelStatusAndPageIdAndTypeVideoImage(1, 1, page.getPageId(), "3");
					pageContent.setGallaryDetailList(gallaryDetailList);
				} else if (moduleList.get(i) == 9) {

					List<NewsDetails> newsBlogList = newsBolgRepo.getNewsContent(langId, page.getPageId());
					pageContent.setDetailNewsList(newsBlogList);
				} else if (moduleList.get(i) == 13) {

					List<TestImonial> testImonialList = testImonialListRepo
							.findByPageIdAndDelStatusAndIsActiveAndSectionIdOrderBySortNo(page.getPageId(), 1, 1, 13,
									langId);
					pageContent.setTeamList(testImonialList);
				} else if (moduleList.get(i) == 8) {

					List<TestImonial> testImonialList = testImonialListRepo
							.findByPageIdAndDelStatusAndIsActiveAndSectionIdOrderBySortNo(page.getPageId(), 1, 1, 8,
									langId);
					pageContent.setSuccessList(testImonialList);
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return pageContent;

	}

	@RequestMapping(value = { "/getLastFourNewsByLangId" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getLastFourNewsByLangId(@RequestParam("langId") int langId) {

		List<NewsDetails> list = new ArrayList<>();

		try {
			list = newsDetailRepo.getLastFourNewsByLangId(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/getAllHomeData" }, method = RequestMethod.POST)
	public @ResponseBody HomeData getAllHomeData(@RequestParam("langId") int langId) {

		HomeData homeData = new HomeData();
		try {

			homeData.setBaner(getLastSliderImagesByStatus(1));
			homeData.setVideoList(getLastTenVideos());
			homeData.setPhotoList(getLastTenPhotos());
			homeData.setCmsList(getCMSDescByExInt1(langId));
			homeData.setNewsList(getLastFourNewsByLangId(langId));
			homeData.setTestimonialList(getLastFiveTestImonials(langId));

			try {

			} catch (Exception e) {
				homeData.setLogoData(getLogoListById(1));
				homeData.setSocialList(getAllSocialList());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return homeData;
	}

	@RequestMapping(value = { "/getLogoListById" }, method = RequestMethod.POST)
	public @ResponseBody Logo getLogoListById(@RequestParam("id") int id) {

		Logo logoSaveResponse = new Logo();

		try {
			logoSaveResponse = LogoRepo.findById(id);
			if (logoSaveResponse == null) {
				logoSaveResponse = new Logo();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return logoSaveResponse;
	}

	@RequestMapping(value = { "/getAllSocialList" }, method = RequestMethod.GET)
	public @ResponseBody List<SocialChannels> getAllSocialList() {

		List<SocialChannels> conList = new ArrayList<SocialChannels>();

		try {

			conList = socialDetailRepo.findByDelStatusAndIsActiveOrderById(1, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return conList;

	}

	@RequestMapping(value = { "/getLastTenVideos" }, method = RequestMethod.GET)
	public @ResponseBody List<GallaryDetail> getLastTenVideos() {
		List<GallaryDetail> secSaveResponse = new ArrayList<GallaryDetail>();

		try {
			secSaveResponse = gallaryDetailRepository.getLastTenVedios();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getLastTenPhotos" }, method = RequestMethod.GET)
	public @ResponseBody List<GallaryDetail> getLastTenPhotos() {
		List<GallaryDetail> secSaveResponse = new ArrayList<GallaryDetail>();

		try {
			secSaveResponse = gallaryDetailRepository.getLastTenPhotos();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getLastSliderImagesByStatus" }, method = RequestMethod.POST)
	public @ResponseBody BannerImages getLastSliderImagesByStatus(@RequestParam("langId") int langId) {

		BannerImages secSaveResponse = new BannerImages();

		try {
			secSaveResponse = bannerImagesRepo.getLastSliderImagesByStatus(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getCMSDescByExInt1" }, method = RequestMethod.POST)
	public @ResponseBody List<CmsSearchData> getCMSDescByExInt1(@RequestParam("langId") int langId) {
		List<CmsSearchData> secSaveResponse = new ArrayList<CmsSearchData>();

		try {
			secSaveResponse = cmsPageDescRepository.getCMSDescByExInt1(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getLastFiveTestImonials" }, method = RequestMethod.POST)
	public @ResponseBody List<TestImonial> getLastFiveTestImonials(@RequestParam("langId") int langId) {
		List<TestImonial> secSaveResponse = new ArrayList<TestImonial>();

		try {
			secSaveResponse = testImonialListRepo.getLastFiveTestImonials(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllImageLinkList" }, method = RequestMethod.GET)
	public @ResponseBody List<ImageLink> getAllImageLinkList() {

		List<ImageLink> imagesList = new ArrayList<ImageLink>();

		try {

			imagesList = imageLinkRepo.findByDelStatusAndIsActiveOrderBySortOrder(1, 1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return imagesList;

	}

	@RequestMapping(value = { "/getAllUpcomingEvents" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllUpcomingEvents(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			secSaveResponse = newsDetailRepo.getAllUpcomingEvents(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllPreviousEvents" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> getAllPreviousEvents(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			secSaveResponse = newsDetailRepo.getAllPreviousEvents(langId);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/saveContactUs" }, method = RequestMethod.POST)
	public @ResponseBody ContactUs saveContactUs(@RequestBody ContactUs getContactList) {

		Info errorMessage = new Info();
		ContactUs ContactUsList = null;
		try {

			ContactUsList = contactUsRepo.save(getContactList);

		} catch (Exception e) {

			e.printStackTrace();
			errorMessage.setError(true);
			errorMessage.setMsg("failed to Save ");

		}
		return ContactUsList;

	}

	@RequestMapping(value = { "/getAllCatIdBySectionIdOrderByDesc" }, method = RequestMethod.POST)
	public @ResponseBody List<GetCategory> getAllCatIdBySectionIdOrderByDesc(@RequestParam("sectionId") int sectionId) {

		List<GetCategory> catList1 = null;

		try {

			catList1 = getGetCategoryRepo.getAllCatIdBySectionIdOrderByDesc(sectionId);

			System.out.println(catList1);
		} catch (Exception e) {
			System.err.println("Exce in getAllCatList @Mastercontr " + e.getMessage());
			e.printStackTrace();
		}

		return catList1;

	}

	@RequestMapping(value = { "/getImages" }, method = RequestMethod.POST)
	public @ResponseBody PageContent getImages(@RequestParam("slugName") String slugName,
			@RequestParam("langId") int langId) {

		PageContent pageContent = new PageContent();
		try {

			Page page = pageRepo.findByPageSlug(slugName, langId);
			List<Integer> moduleList = pagesModuleRepo.getmoduleList(page.getPageId());
			int sectionId = pageRepo.getSectioinId(page.getPageId());
			pageContent.setPageId(page.getPageId());
			pageContent.setPageName(page.getPageName());
			pageContent.setSectioinId(sectionId);
			for (int i = 0; i < moduleList.size(); i++) {

				if (moduleList.get(i) == 3) {

					List<GallaryDetail> gallaryDetailList = gallaryDetailRepository
							.findByIsActiveAndDelStatusAndPageIdAndTypeVideoImage(1, 1, page.getPageId(), "3");
					pageContent.setGallaryDetailList(gallaryDetailList);

					List<ImageListByCategory> imageListByCategoryList = imageListByCategoryRepo
							.imageListByCategoryList(page.getPageId(), langId);
					pageContent.setImageListByCategory(imageListByCategoryList);
				}

				if (moduleList.get(i) == 4) {

					List<GallaryDetail> gallaryDetailList = gallaryDetailRepository
							.findByIsActiveAndDelStatusAndPageIdAndTypeVideoImage(1, 1, page.getPageId(), "4");
					pageContent.setVideoList(gallaryDetailList);

					List<ImageListByCategory> imageListByCategoryList = imageListByCategoryRepo
							.imageListByCategoryList(page.getPageId(), langId);
					pageContent.setImageListByCategory(imageListByCategoryList);
				}

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return pageContent;

	}

	@RequestMapping(value = { "/checkUniqueField" }, method = RequestMethod.POST)
	public @ResponseBody Info checkUniqueField(@RequestParam String inputValue, @RequestParam int valueType,
			@RequestParam int primaryKey) {

		Info info = new Info();

		List<Registration> instList = new ArrayList<Registration>();

		if (valueType == 1) {
			System.err.println("Its Contact No check");

			System.err.println("Its New Record Insert ");
			instList = registrationRepo.findByMobileNumberAndDelStatusAndSmsVerified(inputValue.trim(), 1, 1);
			System.err.println("instList for mob" + instList.toString());

		} else if (valueType == 2) {
			System.err.println("Its Email check");

			System.err.println("Its New Record Insert ");
			instList = registrationRepo.findByEmailsAndDelStatusAndSmsVerified(inputValue.trim(), 1, 1);

			System.err.println("instList for email" + instList.toString());

		}
		if (instList.size() > 0) {
			info.setError(true);
			info.setMsg("duplicate");
		} else {
			info.setError(false);
			info.setMsg("unique");
		}

		System.err.println("info is " + info.toString());
		return info;
	}

	@RequestMapping(value = { "/newsListForHomePage" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> newsListForHomePage(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			Date newDate = new Date(today.getTime() - 604800000L);

			secSaveResponse = newsDetailRepo.newsListForHomePage(langId, sf.format(newDate));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getAllRegisteredEvents" }, method = RequestMethod.GET)
	public @ResponseBody List<EventRegistration> getAllRegisteredEvents() {
		List<EventRegistration> secSaveResponse = new ArrayList<EventRegistration>();

		try {
			secSaveResponse = eventRegRepo.findAll();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getCategoryListWithImageCount" }, method = RequestMethod.POST)
	public @ResponseBody List<CategoryListWithContentCount> getCategoryListWithImageCount(
			@RequestParam("sectionId") int sectionId, @RequestParam("langId") int langId) {

		List<CategoryListWithContentCount> list = new ArrayList<>();

		try {

			list = categoryListWithContentCountRepo.getCategoryListWithImageCount(sectionId, langId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/newsExpiredListForHomePage" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsDetails> newsExpiredListForHomePage(@RequestParam("langId") int langId) {
		List<NewsDetails> secSaveResponse = new ArrayList<NewsDetails>();

		try {
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			Date newDate = new Date(today.getTime() - 604800000L);
			secSaveResponse = newsDetailRepo.newsExpiredListForHomePage(langId, sf.format(newDate));
		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getUniversityList" }, method = RequestMethod.GET)
	public @ResponseBody List<University> getUniversityList() {

		List<University> list = new ArrayList<>();

		try {

			list = universityRepo.findByDelStatusOrderByUniNameAsc(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/getInstituteListByUniversityId" }, method = RequestMethod.POST)
	public @ResponseBody List<InstituteInfo> getInstituteListByUniversityId(@RequestParam("uniId") int uniId) {

		List<InstituteInfo> list = new ArrayList<>();

		try {

			list = instituteInfoRepo.getInstituteListByUniversityId(uniId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/getInstituteInfoById" }, method = RequestMethod.POST)
	public @ResponseBody InstituteInfo getInstituteInfoById(@RequestParam("instiId") int instiId) {

		InstituteInfo instituteInfo = new InstituteInfo();

		try {

			instituteInfo = instituteInfoRepo.getInstituteInfoById(instiId);

			if (instituteInfo == null) {
				instituteInfo = new InstituteInfo();
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return instituteInfo;

	}

	@RequestMapping(value = { "/getDocTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<DocType> getDocTypeList() {

		List<DocType> list = new ArrayList<>();

		try {

			list = docTypeRepo.findByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/getInstituteInfoByAsheCode" }, method = RequestMethod.POST)
	public @ResponseBody InstituteInfo getInstituteInfoByAsheCode(@RequestParam("asheCode") String asheCode) {

		InstituteInfo instituteInfo = new InstituteInfo();

		try {

			instituteInfo = instituteInfoRepo.getInstituteInfoByAsheCode(asheCode);

			if (instituteInfo == null) {
				instituteInfo = new InstituteInfo();
			} else {
				int yesNo = instituteInfoRepo.registerOrnot(asheCode);

				if (yesNo > 0) {
					instituteInfo.setYesNo(1);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return instituteInfo;

	}

	@RequestMapping(value = { "/checkIsMaintenance" }, method = RequestMethod.GET)
	public @ResponseBody Maintainance checkIsMaintenance() {

		Maintainance maintainance = new Maintainance();

		try {

			maintainance = siteMaintenanceRepo.checkIsMaintenance();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return maintainance;

	}

	@RequestMapping(value = { "/getPageMetaData" }, method = RequestMethod.POST)
	public @ResponseBody PageMetaData getPageMetaData(@RequestParam("slugName") String slugName) {

		PageMetaData pageMetaData = new PageMetaData();

		try {

			pageMetaData = pageMetaDataRepo.getPageMetaData(slugName);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return pageMetaData;

	}

	@RequestMapping(value = { "/getHomePageMetaDataByLangId" }, method = RequestMethod.POST)
	public @ResponseBody MetaData getHomePageMetaDataByLangId(@RequestParam("langId") int langId) {

		MetaData metaResponse = new MetaData();

		try {
			metaResponse = metaDataRepo.findByLanguageId(langId);
			System.out.println(metaResponse);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return metaResponse;
	}

	@RequestMapping(value = { "/getEventListforCalender" }, method = RequestMethod.GET)
	public @ResponseBody CalenderList getEventListforCalender() {

		CalenderList calenderList = new CalenderList();

		try {
			List<Result> result = resultRepository.getEventListforCalender();
			calenderList.setResult(result);
			calenderList.setSuccess(1);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return calenderList;
	}

	@RequestMapping(value = { "/allPreviousEventWithAplliedForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<EventRecord> allPreviousEventWithAplliedForApp(@RequestParam("langId") int langId,
			@RequestParam("userId") int userId, @RequestParam("token") String token) {
		List<EventRecord> secSaveResponse = new ArrayList<EventRecord>();

		try {

			Info info = checkToken(token, userId);
			if (info.isError() == false) {
				secSaveResponse = eventRecordRepo.getAllPreviousEvents(langId, userId);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return secSaveResponse;
	}

	@RequestMapping(value = { "/getNewsSectionBySectionId" }, method = RequestMethod.POST)
	public @ResponseBody List<NewsSectionList> getNewsSectionBySectionId(@RequestParam("sectionId") int sectionId,
			@RequestParam("langId") int langId) {

		List<NewsSectionList> newsSectionList = new ArrayList<>();

		try {

			newsSectionList = newsSectionListRepo.getNewsSectionBySectionId(sectionId, langId);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return newsSectionList;

	}

	@RequestMapping(value = { "/getPrevRecordByRegIdForApp" }, method = RequestMethod.POST)
	public @ResponseBody PreviousRegRecord getPrevRecordByRegIdForApp(@RequestParam("regId") int regId,
			@RequestParam("token") String token) {

		PreviousRegRecord getPrevRecordByRegId = new PreviousRegRecord();

		try {

			Info info = checkToken(token, regId);
			if (info.isError() == false) {

				getPrevRecordByRegId = previousRegRecordRepo.findByRegId(regId);

				if (getPrevRecordByRegId == null) {

					getPrevRecordByRegId = new PreviousRegRecord();
					getPrevRecordByRegId.setError(true);
					getPrevRecordByRegId.setMessage("Not Found");
				} else {

					getPrevRecordByRegId.setError(false);
					getPrevRecordByRegId.setMessage("Found");

					ObjectMapper mapper = new ObjectMapper();
					RegistrationUserDetail jsonRecord = mapper.readValue(getPrevRecordByRegId.getRecord(),
							RegistrationUserDetail.class);
					jsonRecord.setUserPassword("");
					jsonRecord.setSmsCode("");
					mapper = new ObjectMapper();
					getPrevRecordByRegId.setRecord(mapper.writeValueAsString(jsonRecord));
				}
			} else {
				getPrevRecordByRegId.setError(true);
				getPrevRecordByRegId.setMessage("Unauthorized User");
			}
		} catch (Exception e) {

			e.printStackTrace();
			getPrevRecordByRegId = new PreviousRegRecord();
			getPrevRecordByRegId.setError(true);
			getPrevRecordByRegId.setMessage("Not Found");

		}
		return getPrevRecordByRegId;

	}

	@RequestMapping(value = { "/getDocumentByRegIdForApp" }, method = RequestMethod.POST)
	public @ResponseBody List<UploadDocument> getDocumentByRegId(@RequestParam("regId") int regId,
			@RequestParam("token") String token) {

		List<UploadDocument> list = new ArrayList<>();

		try {
			Info info = checkToken(token, regId);
			if (info.isError() == false) {
				list = uploadDocumentRepo.getDocumentByRegId(regId);

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return list;

	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public @ResponseBody String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		try {

			Cookie[] cookies = request.getCookies();
			if (cookies != null)
				for (Cookie cookie : cookies) {
					cookie.setValue("");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}

			session.invalidate();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return "redirect:/";

	}

	public Info checkToken(String token, int regId) throws IOException {

		Info info = new Info();

		try {
			if (!token.isEmpty() && token != "") {
				Registration res = registrationRepo.findByExVar2AndRegIdAndDelStatus(token, regId, 1);

				if (res == null) {
					info.setError(true);
					info.setMsg("token not matched");
				} else {
					info.setError(false);
					info.setMsg("authorized user");
				}
			} else {
				info.setError(true);
				info.setMsg("Unauthorized User");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("token not match");
		}
		return info;
	}

}
