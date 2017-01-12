create table PagesStorage_Page (
	pageId LONG not null primary key,
	url VARCHAR(75) null,
	description VARCHAR(75) null,
	image VARCHAR(75) null
);

create table PagesStorage_Word (
	wordId LONG not null primary key,
	pageId LONG,
	word VARCHAR(75) null
);

create table UrlStorage_Page (
	url_id LONG not null primary key,
	url VARCHAR(75) null,
	description VARCHAR(75) null,
	image VARCHAR(75) null
);

create table UrlStorage_Page_Word (
	companyId LONG not null,
	url_id LONG not null,
	word_id LONG not null,
	primary key (url_id, word_id)
);

create table UrlStorage_Pages (
	url_id LONG not null primary key,
	url VARCHAR(75) null,
	description VARCHAR(75) null,
	image VARCHAR(75) null
);

create table UrlStorage_Pages_Words (
	companyId LONG not null,
	url_id LONG not null,
	word_id LONG not null,
	primary key (url_id, word_id)
);

create table UrlStorage_Word (
	word_id LONG not null primary key,
	url_id LONG,
	word VARCHAR(75) null
);

create table UrlStorage_Words (
	word_id LONG not null primary key,
	url_id LONG,
	word VARCHAR(75) null
);