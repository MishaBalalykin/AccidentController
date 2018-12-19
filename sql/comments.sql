--COMMENT ACCIDENT--	

COMMENT ON TABLE ACCIDENT IS 'Base table contains only address and date of accident and references on proof tables and creator_info table';

COMMENT ON COLUMN ACCIDENT.ID IS 'Prymary key to reference on proof tables and creator_info table';

COMMENT ON COLUMN ACCIDENT.ACCIDENT_ADDRESS IS 'Address of accident';

COMMENT ON COLUMN ACCIDENT.ACCIDENT_DATE IS 'Date of accident';


--COMMENT CREATOR_INFO--

COMMENT ON TABLE CREATOR_INFO IS 'Table witch contains contacts of a creator';

COMMENT ON COLUMN CREATOR_INFO.ACCIDENT_ID IS 'Foreign key and primary key to reference from table accident and to have unuque values generating by hibernate';

COMMENT ON COLUMN CREATOR_INFO.NAME IS 'Name of a creator';

COMMENT ON COLUMN CREATOR_INFO.PHONE_NUMBER IS 'Creator s phone number';

COMMENT ON COLUMN CREATOR_INFO.OTHER_CONTACTS IS 'Other contact info(not mandatory)';


--COMMENT MEDIA_PROOF--

COMMENT ON TABLE MEDIA_PROOF IS 'Table witch contains video or photo proof';

COMMENT ON COLUMN MEDIA_PROOF.ID IS 'Primary key';

COMMENT ON COLUMN MEDIA_PROOF.ACCIDENT_ID IS 'Foreign key to reference from table accident';

COMMENT ON COLUMN MEDIA_PROOF.PROOF IS 'Video or photo proof';


--COMMENT TEXT_PROOF--

COMMENT ON TABLE TEXT_PROOF IS 'Table witch contains text proof';

COMMENT ON COLUMN TEXT_PROOF.ACCIDENT_ID IS 'Foreign key and primary key to reference from table accident and to have unuque values generating by hibernate';

COMMENT ON COLUMN TEXT_PROOF.PROOF IS 'Text proof';


