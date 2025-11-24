create view example.VBook as
select
b.*,
'' otherAuthor
from 
example.Book b