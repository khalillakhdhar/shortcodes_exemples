  public void updateStudent(Student student) {
        Transaction transaction = null;
        try  {
            // start a transaction
          (Session session = HibernateUtil.getSessionFactory().openSession());
            transaction = session.beginTransaction();

            // save the student object
            String hql = "UPDATE Student set firstName = :firstName " + "WHERE id = :studentId";
            Query query = session.createQuery(hql);
            query.setParameter("firstName", student.getFirstName());
            query.setParameter("studentId", 1);
            int result = query.executeUpdate();
            System.out.println("Rows affected: " + result);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
