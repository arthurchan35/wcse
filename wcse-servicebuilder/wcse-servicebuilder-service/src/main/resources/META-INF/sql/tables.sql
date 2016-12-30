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

create table UrlStorage_Words (
	word_id LONG not null primary key,
	url_id LONG,
	word VARCHAR(75) null
);