create table PagesStorage_Page (
	pageId LONG not null primary key,
	url VARCHAR(1024) null,
	description VARCHAR(2048) null,
	image TEXT null
);

create table PagesStorage_Word (
	wordId LONG not null primary key,
	pageId LONG,
	word VARCHAR(75) null
);