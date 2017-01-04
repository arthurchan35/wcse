create unique index IX_AF16C4B7 on UrlStorage_Page (url[$COLUMN_LENGTH:75$]);

create index IX_6D63BB9B on UrlStorage_Page_Word (companyId);
create index IX_1FFB8C0C on UrlStorage_Page_Word (url_id);
create index IX_15BF21D3 on UrlStorage_Page_Word (word_id);

create index IX_E3E117E7 on UrlStorage_Pages_Words (companyId);
create index IX_AD187340 on UrlStorage_Pages_Words (url_id);
create index IX_2C3F211F on UrlStorage_Pages_Words (word_id);