package com.tarasenko.graphqlusers.fetchers;

import org.springframework.stereotype.Component;

import com.tarasenko.graphqlusers.entity.Company;
import com.tarasenko.graphqlusers.entity.Position;
import com.tarasenko.graphqlusers.entity.User;
import com.tarasenko.graphqlusers.repository.CompanyRepository;
import com.tarasenko.graphqlusers.repository.PositionRepository;
import com.tarasenko.graphqlusers.repository.UserRepository;

import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers
{

  private final UserRepository userRepository;
  private final CompanyRepository companyRepository;
  private final PositionRepository positionRepository;

  public GraphQLDataFetchers(UserRepository userRepository, CompanyRepository companyRepository,
                             PositionRepository positionRepository)
  {
    this.userRepository = userRepository;
    this.companyRepository = companyRepository;
    this.positionRepository = positionRepository;
  }

  public DataFetcher<User> getUserById()
  {
    return dataFetchingEnvironment -> {
      Long userId = Long.valueOf(dataFetchingEnvironment.getArgument("id"));
      return userRepository.findById(userId)
          .orElse(null);
    };
  }

  public DataFetcher<Company> getCompanyById()
  {
    return dataFetchingEnvironment -> {
      Long companyId = Long.valueOf(dataFetchingEnvironment.getArgument("id"));
      return companyRepository.findById(companyId)
          .orElse(null);
    };
  }

  public DataFetcher<Position> getPositionById()
  {
    return dataFetchingEnvironment -> {
      Long positionId = Long.valueOf(dataFetchingEnvironment.getArgument("id"));
      return positionRepository.findById(positionId)
          .orElse(null);
    };
  }

}
