package use_case.fill_detail;

import entity.FetchedData;
import use_case.query.QueryDataAccessInterface;
import use_case.star.StarDataAccessInterface;

import java.io.IOException;

public class FillDetailInteractor implements FillDetailInputBoundary{
    private final FillDetailOutputBoundary fillDetailPresenter;
    private final QueryDataAccessInterface queryDAO;

    public FillDetailInteractor(FillDetailOutputBoundary fillDetailPresenter, QueryDataAccessInterface queryDAO, StarDataAccessInterface starDAO) {
        this.fillDetailPresenter = fillDetailPresenter;
        this.queryDAO = queryDAO;

    }

    @Override
    public void execute(FetchedData inputData) {
        try {
            FetchedData updatedData = queryDAO.fillDetails(inputData);
            fillDetailPresenter.prepareSuccessView(updatedData);
        } catch (IOException e) {
            fillDetailPresenter.prepareFailView("Failed filling details for entry \"" + inputData.getTitle() + "\"");
        }
    }
}
