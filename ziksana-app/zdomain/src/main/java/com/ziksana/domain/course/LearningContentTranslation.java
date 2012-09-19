package com.ziksana.domain.course;

public class LearningContentTranslation {
	/**
	 * This field corresponds to the database column
	 * corlearningcontenttranslation.contentTranslationId
	 */
	private Integer contentTranslationId;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttranslation.TranslationType
	 */
	private Integer translationType;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttranslation.TranslatedLanguage
	 */
	private Integer translatedLanguage;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttranslation.TranslationContentPath
	 */
	private String translationContentPath;

	/**
	 * This field corresponds to the database column
	 * corlearningcontenttranslation.LearningContentId
	 */
	private Integer learningContentId;

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttranslation.contentTranslationId
	 * 
	 * @return the value of corlearningcontenttranslation.contentTranslationId
	 */
	public Integer getContentTranslationId() {
		return contentTranslationId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttranslation.contentTranslationId
	 * 
	 * @param contentTranslationId
	 *            the value for corlearningcontenttranslation.contentTranslationId
	 */
	public void setContentTranslationId(Integer contentTranslationId) {
		this.contentTranslationId = contentTranslationId;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttranslation.TranslationType
	 * 
	 * @return the value of corlearningcontenttranslation.TranslationType
	 */
	public Integer getTranslationType() {
		return translationType;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttranslation.TranslationType
	 * 
	 * @param translationType
	 *            the value for corlearningcontenttranslation.TranslationType
	 */
	public void setTranslationType(Integer translationType) {
		this.translationType = translationType;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttranslation.TranslatedLanguage
	 * 
	 * @return the value of corlearningcontenttranslation.TranslatedLanguage
	 */
	public Integer getTranslatedLanguage() {
		return translatedLanguage;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttranslation.TranslatedLanguage
	 * 
	 * @param translatedLanguage
	 *            the value for corlearningcontenttranslation.TranslatedLanguage
	 */
	public void setTranslatedLanguage(Integer translatedLanguage) {
		this.translatedLanguage = translatedLanguage;
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttranslation.TranslationContentPath
	 * 
	 * @return the value of corlearningcontenttranslation.TranslationContentPath
	 */
	public String getTranslationContentPath() {
		return translationContentPath;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttranslation.TranslationContentPath
	 * 
	 * @param translationContentPath
	 *            the value for
	 *            corlearningcontenttranslation.TranslationContentPath
	 */
	public void setTranslationContentPath(String translationContentPath) {
		this.translationContentPath = translationContentPath == null ? null
				: translationContentPath.trim();
	}

	/**
	 * This method returns the value of the database column
	 * corlearningcontenttranslation.LearningContentId
	 * 
	 * @return the value of corlearningcontenttranslation.LearningContentId
	 */
	public Integer getLearningContentId() {
		return learningContentId;
	}

	/**
	 * This method sets the value of the database column
	 * corlearningcontenttranslation.LearningContentId
	 * 
	 * @param learningContentId
	 *            the value for corlearningcontenttranslation.LearningContentId
	 */
	public void setLearningContentId(Integer learningContentId) {
		this.learningContentId = learningContentId;
	}
}