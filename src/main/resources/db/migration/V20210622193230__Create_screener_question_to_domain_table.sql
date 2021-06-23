create schema if not exists screener;

create table screener.question_to_domain(
    screener_id text not null,
    question_id text not null,
    domain text not null,

    primary key (screener_id, question_id)
);

insert into screener.question_to_domain (screener_id, question_id, domain) VALUES
    ('abcd-123', 'question_a', 'depression'),
    ('abcd-123', 'question_b', 'depression'),
    ('abcd-123', 'question_c', 'mania'),
    ('abcd-123', 'question_d', 'mania'),
    ('abcd-123', 'question_e', 'anxiety'),
    ('abcd-123', 'question_f', 'anxiety'),
    ('abcd-123', 'question_g', 'anxiety'),
    ('abcd-123', 'question_h', 'substance_use');
