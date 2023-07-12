select ta.name from member m, task ta where ta.owner=m.id and m.id=?;

select td.title, td.deadline from task ta, todo td where td.task=ta.id;