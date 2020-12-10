public Student getStudent(int id) {

        Transaction transaction = null;
        Student student = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // get an student object
            String hql = " FROM Student S WHERE S.id = :studentId";
            Query query = session.createQuery(hql);
            query.setParameter("studentId", id);
            List results = query.getResultList();

            if (results != null && !results.isEmpty()) {
                student = (Student) results.get(0);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return student;
    }
