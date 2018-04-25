SELECT event_name, count_star, sum_timer_wait
FROM performance_schema.events_waits_summary_global_by_event_name
ORDER BY sum_timer_wait DESC LIMIT 5;
