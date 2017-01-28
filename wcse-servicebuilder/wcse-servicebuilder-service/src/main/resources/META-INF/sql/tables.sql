create table PagesStorage_Page (
	pageId LONG not null primary key,
	url VARCHAR(75) null,
	description VARCHAR(75) null,
	image BLOB
);

create table PagesStorage_Word (
	wordId LONG not null primary key,
	pageId LONG,
	word VARCHAR(75) null
);